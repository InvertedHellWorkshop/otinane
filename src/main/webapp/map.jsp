
<!--
* Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
*/-->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<!DOCTYPE html>
<html>
<head>

    <title>Geolocation</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link href="${contextPath}/resources/css/map.css" rel="stylesheet">
    <style>

    </style>
</head>
<body>

<div id="map-canvas">
</div>
<div class="invButton overlap">

    <div id="InvButton">
        <a id="displaytext" href="javascript:toggle();">View inventory</a>
    </div>
</div>

<div class="LogOut overlap">
    <div id="logOut">
        <a type="button" onclick="ChangeState()">Logout</a>
    </div>

</div>
<script language="javascript">

    function toggle() {

        var ele = document.getElementById("inventory");

        var text = document.getElementById("displayinventory");

        if(ele.style.display == "block") {

            ele.style.display = "none";

            text.innerHTML = "show";

        }

        else {

            ele.style.display = "block";

            text.innerHTML = "hide";

        }

    }

</script>

<div class="inventory overlap">

    <div id="inventory">
    </div>
    <div class="msgBox overlap">
        <div id="msgBox">

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <!--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                </form>

                <h2 id="welcomeMsg">Welcome ${pageContext.request.userPrincipal.name} !


            </c:if>

            <h3><font color="#1e90ff">Info:</font>To Win this game you need to solve The Last Riddle(Diploma)!<font color="#1e90ff">Tip:</font>The answers from the Green Marker's Riddle can help you solve The Last Riddle.</h3>
            <h2 id="message"></h2>


            <p>  <script>
                var message2 = "${message}";

                console.log("Status -> " + sessionStorage.getItem("is_reloaded"));
                //$('#welcomeMsg').css('display', 'block');

                if (sessionStorage.getItem("is_reloaded")) {
                    // $('#welcomeMsg').hide();
                    $('#welcomeMsg').css('display', 'none');
                }
                else {
                    sessionStorage.setItem("is_reloaded", true);
                    //$('#welcomeMsg').show();
                    $('#welcomeMsg').css('display', 'block');
                }

                function ChangeState() {
                    console.log("Here");
                    sessionStorage.setItem("is_reloaded", false);
                    // $('#welcomeMsg').show();

                    $("#logoutForm").submit();
                    //document.forms['logoutForm'].submit()

                }





                document.write(message2);
            </script>
            </p>


        </div>
        <script>
            close = document.getElementById("close");
            close.addEventListener('click', function() {
                var msgBox = document.getElementById("msgBox");
                msgBox.style.display = 'none';
            }, false);
        </script>
    </div>
</div>
<script>
    var x = document.getElementById("map-canvas");
    function initMap() {

        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);

        }


        function showPosition(position) {

            var latx = position.coords.latitude;
            var lonx = position.coords.longitude;
            var resultx = new google.maps.LatLng(latx, lonx);
            var map = new google.maps.Map(document.getElementById('map-canvas'), {
                zoom: 15,
                scrollwheel: true,
                center: resultx,
                mapTypeId: google.maps.MapTypeId.ROADMAP

            });


            var infowindow = new google.maps.InfoWindow();


            //Επιστρεφει ολα τα items που υπαρχουν στη βάση
            var xmlhttp = new XMLHttpRequest();
            var getAllItems = "${contextPath}/items";
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var itemsCollection = JSON.parse(this.responseText);
                    f1(itemsCollection);
                }
            };
            xmlhttp.open("GET", getAllItems, true);
            xmlhttp.send();
            ///////////////////


            //Βοηθητική συνάρτηση για να μαζευτουν τα items με το inventory του εκάστοτε χρήστη
            function f1(itemsCollection)
            {
                var xmlhttp = new XMLHttpRequest();
                var getInventory = "${contextPath}/inventory?username=${pageContext.request.userPrincipal.name}";
                xmlhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var inventoryCollection = JSON.parse(this.responseText);
                        showMarkers(itemsCollection, inventoryCollection);
                    }
                };
                xmlhttp.open("GET", getInventory, true);
                xmlhttp.send();
            }
            //////////////////
            var full_list="";
            var countItems=0;
            //Εμφανιση markers
            function showMarkers(items, inventory) {
                var i;
                var y=0;
                var hasItem = false;
                var k=1;

                //Ελέγχος εάν ο marker του item που πρόκυτε να εμφανιστεί υπάρχει στο inventory του χρήστη
                //Εάν υπάρχει φτιαχνει εναν marker solved, αλλιως φτιαχνει marker unsolved

                for (i = 0; i < 4; i++) {
                    var position = createPosition(items[i]);
                    var icon = createIcon(items[i]);
                    for (y = 0; y < inventory.length; y++) {
                        //  if (countItems > 3) {
                        //     k = 3;
                        //     break;
                        // } else
                        if (items[i].name == inventory[y].name) {
                            full_list = full_list + items[i].sapantisi + ",";
                            countItems = countItems + 1;

                            k = 2;
                            break;
                        }
                    }
                    $("#inventory").text(full_list);
                    if (k == 2)var solved = createMarkerSolved(position, items[i], icon);
                    //  else if (k == 3) threeMarkersSolved(position, items[i], icon);

                    else var unsolved = createMarker(position, items[i], icon);
                    k = 1;

                    // if (countItems == 3) {
                    //     i = 0;
                    //     countItems = countItems + 1;

                    // }

                }

            }


            function createPosition(item){
                var pos = new google.maps.LatLng(item.latitude, item.longitude);
                return pos;
            }
            function createIcon(item) {
                var icon = {
                    url: '${contextPath}/resources/icons/' + item.name + '.png',
                    size: new google.maps.Size(55, 55),
                    origin: new google.maps.Point(0, 0),
                    anchor: new google.maps.Point(17, 34),
                    scaledSize: new google.maps.Size(55, 55)
                };
                return icon;
            }

            //Δημιουργία marker αλυτου γρίφου
            var message;
            function createMarker(pos, item, icon) {
                var marker = new google.maps.Marker({
                    position: pos,
                    map: map,
                    icon: icon,
                    optimized: false
                });
                var infowindow = new google.maps.InfoWindow();
                var title = new google.maps.InfoWindow({
                    content: item.name
                });
                //Δημιουργεία Φόρμας για απάντηση
                var answerHtml = item.description+
                        '<br>'+
                        '<input type="text" name="username" value=${pageContext.request.userPrincipal.name} hidden="true">'+
                        'Answer :  '+ '<input type="text" name="item" id="userAnswer">'+
                        '<button onclick="checkAnswer()">></button><br>';

                var radius = 0.000120;
                var bottomItemLat = item.latitude - radius;
                var upperItemLat = item.latitude + radius;
                var bottomItemLng = item.longitude - radius;
                var upperItemLng = item.longitude + radius;

                google.maps.event.addListener(marker, 'click', function() {

                      if ((latx >= upperItemLat || latx <= bottomItemLat) && (lonx >= upperItemLng || lonx <= bottomItemLng)) {
                    infowindow.setContent("You are not in range to see this riddle");
                      } else {

                    infowindow.setContent(answerHtml);
                     }
                    //Ελέγχει την απαντηση απο τη "φόρμα" στη παραπάνω γραμμή <<infowindow.setContent(answerHtml)>>

                    checkAnswer = function() {
                        //Παίρνει την απάντηση του χρήστη απο το input της "φόρμας"
                        var userAnswer = document.getElementById("userAnswer").value;
                        //Ελέγχει άμα ειναι ίδια με την απάντηση του item.
                        //Επισης μεσα στο if και στο else μπορουν να μπουν document.getElementById("msgBox") κλπ
                        // για να εμφανίζει σε κάποιο div έξω απο τη συνάρτηση showposition(position) τα μνματα
                        // σωστου λάθους και λοιπά....
                        if(userAnswer == item.sapantisi){
                            //Κάνει POST στο inventory αμα είναι σωστή η απάντηση του
                            var xmlhttp = new XMLHttpRequest();
                            var postInventory = "${contextPath}/inventory";
                            var params = "username=${pageContext.request.userPrincipal.name}&item="+item.name;
                            xmlhttp.open("POST", postInventory, true);
                            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                            xmlhttp.setRequestHeader("Content-length", params.length);
                            xmlhttp.setRequestHeader("Connection", "close");
                            if (item.latitude==41.075322 && item.longitude==23.554138){
                                document.getElementById("message").innerHTML = "<font color='#00ff7f'>You answer correct on all our riddles..this is the end of the Game.You can now log out</font>";


                            }else {
                                document.getElementById("message").innerHTML = "<font color='#00ff7f'>You answer ( " + userAnswer + " ) on this riddle is correct and now you have a new item in your inventory!</font>";
                            }
                            xmlhttp.onreadystatechange = function () {
                                if (this.readyState == 4 && this.status == 200) {
                                    //Ανανεώνει μόνο τον χάρτη για να εμφανιστουν ξανά οι markers με τον καινουργιο λυμένο
                                    showPosition(position);

                                }
                            };

                            xmlhttp.send(params);

                        }else{
                            //Αν δεν εχει βρει τη σωστή απάντηση του ξανα εμφανίζει τη φόρμα για να ξαναπροσπαθήσει
                            infowindow.setContent(answerHtml)
                            document.getElementById("message").innerHTML = "<font color='red'>You answer ( "+userAnswer+" ) is false ,please try again !</font>";
                        }
                    };
                    infowindow.open(map, marker);
                });

                google.maps.event.addListener(marker, 'mouseover', function () {
                    title.open(map, marker);
                });
                marker.addListener('mouseout', function() {
                    title.close();
                });
                return marker;
            }

            //Δημιουργεία marker λυμένου γρίφου
            function createMarkerSolved(pos, item, icon) {
                var Diploma="Diploma";
                var marker = new google.maps.Marker({
                    position: pos,
                    map: map,
                    icon: icon
                });
                var infowindow = new google.maps.InfoWindow();
                var title = new google.maps.InfoWindow({
                    content: item.name
                });
                google.maps.event.addListener(marker, 'click', function () {
                    infowindow.setContent("<font color=green><h4>Your Answer about this riddle was Correct</h4></font>");
                    infowindow.open(map, marker);
                });

                google.maps.event.addListener(marker, 'mouseover', function () {
                    title.open(map, marker);
                });
                marker.addListener('mouseout', function() {
                    title.close();
                });
                return marker;
            }
            function reloadMarkers() {
            }

            function threeMarkersSolved(pos,icon){
                var marker = new google.maps.Marker({
                    position: pos,
                    map: map,
                    icon: icon
                });
                marker.setMap(null);
                return marker;
            }





            var imageChar = {
                url: 'http://i747.photobucket.com/albums/xx112/Studio-119-Degrees/Logos%20and%20Icons/icon-dex-littleguy.png',
                // This marker is 20 pixels wide by 32 pixels high.
                size: new google.maps.Size(55, 55),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(55, 55)
            };
            var marker2 = new google.maps.Marker({

                position: new google.maps.LatLng(latx, lonx),
                map: map,
                icon: imageChar

            });
            // To add the marker to the map, call setMap();
            // marker.setMap(map);

// To remove the marker from the map
            // marker.setMap(null);
            google.maps.event.addListener(marker2, 'click', (function (marker2) {
                return function () {
                    infowindow.setContent("You are HERE");
                    infowindow.open(map, marker2);
                }
            })(marker2))

        }





    }

</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDZ_CL_bAA7VK5OVfdkZNRSF8s7qEkcPj0&callback=initMap">
</script>
</body>
<script type="text/javascript">
    // <![CDATA[
    if ("http:" == document.location.protocol || "https:" == document.location.protocol) {
        document.write(unescape("%3Cscript src='" + (("https:" == document.location.protocol) ? "https://dq14tx02jmrhj.cloudfront.net" : "http://cdn.betaeasy.com") + "/betaeasy.js' type='text/javascript'%3E%3C/script%3E"))
    }
    // ]]>
</script>
<script type="text/javascript">
    // <![CDATA[
    try {
        BetaEasy.init({
            betaId: '2144',
            styleType: 'new',
            buttonAlign: 'right',
            language: 'en',
            buttonBackgroundColor: '#f00',
            buttonMouseHoverBackgroundColor: '#06C',
            buttonImageActive: 'en/newbtn-13.png',
            buttonImageHover: 'none',
            backgroundColor: 'undefined',
            tabsInactiveColor: 'undefined',
            tabsInactiveTextColor: 'undefined'
        });
    } catch(err) {}
    // ]]>
</script>
</html>