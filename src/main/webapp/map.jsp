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
    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map-canvas {
            height: 100%;
        }
        /* Optional: Makes the sample page fill the window. */
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div id="map-canvas"></div>
<script>
    // Note: This example requires that you consent to location sharing when
    // prompted by your browser. If you see the error "The Geolocation service
    // failed.", it means you probably did not give permission for the browser to
    // locate you.
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
                zoom: 17,
                scrollwheel: true,
                center: resultx,
                mapTypeId: google.maps.MapTypeId.ROADMAP


            });


            var infowindow = new google.maps.InfoWindow();

            var imageDiploma = {
                url: 'http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons-256/yellow-comment-bubbles-icons-people-things/067543-yellow-comment-bubbles-icon-people-things-diploma-sc2.png',
                // This marker is 20 pixels wide by 32 pixels high.
                size: new google.maps.Size(70, 70),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(70, 70)

            };


            var marker4 = new google.maps.Marker({

                position: new google.maps.LatLng(41.075322, 23.554138),
                map: map,
                icon: imageDiploma

            });




            google.maps.event.addListener(marker4, 'click', (function (marker4) {
                return function () {
                    infowindow.setContent("Diploma");
                    infowindow.open(map, marker4);
                }
            })(marker4))

            var imageCoffee = {
                url: 'https://cdn4.iconfinder.com/data/icons/maps-and-navigation-solid-icons-vol-1/72/46-512.png',
                // This marker is 20 pixels wide by 32 pixels high.
                size: new google.maps.Size(55, 55),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(55, 55)

            };


            var marker3 = new google.maps.Marker({

                position: new google.maps.LatLng(41.074687, 23.553934),
                map: map,
                icon: imageCoffee

            });




            google.maps.event.addListener(marker3, 'click', (function (marker3) {
                return function () {
                    infowindow.setContent("Coffee");
                    infowindow.open(map, marker3);
                }
            })(marker3))



            var imageChar = {
                url: 'http://i747.photobucket.com/albums/xx112/Studio-119-Degrees/Logos%20and%20Icons/icon-dex-littleguy.png',
                // This marker is 20 pixels wide by 32 pixels high.
                size: new google.maps.Size(55, 55),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(55, 55)

            };


            var marker2 = new google.maps.Marker({

                position: new google.maps.LatLng(latx , lonx),
                map: map,
                icon: imageChar

            });




            google.maps.event.addListener(marker2, 'click', (function (marker2) {
                return function () {
                    infowindow.setContent("You are HERE");
                    infowindow.open(map, marker2);
                }
            })(marker2))


            var imageFood = {
                url: 'http://www.freeiconspng.com/uploads/map-navigation-pin-point-restaurant-icon--14.png',
                // This marker is 20 pixels wide by 32 pixels high.
                size: new google.maps.Size(55, 55),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(55, 55)

            };




            var marker = new google.maps.Marker({

                position: new google.maps.LatLng(41.075723, 23.551064),
                map: map,
                icon: imageFood,

            });



            google.maps.event.addListener(marker, 'click', (function (marker) {
                return function () {
                    infowindow.setContent("Food");
                    infowindow.open(map, marker);
                }
            })(marker))


            var imageBooks = {
                url: 'https://cdn1.iconfinder.com/data/icons/map-objects/154/map-object-library-book-read-place-512.png',
                // This marker is 20 pixels wide by 32 pixels high.
                size: new google.maps.Size(55, 55),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(55, 55)

            };


            var marker1 = new google.maps.Marker({

                position: new google.maps.LatLng(41.076224, 23.554250),
                map: map,
                icon: imageBooks

            });



            google.maps.event.addListener(marker1, 'click', (function (marker1) {
                return function () {
                    infowindow.setContent("Books");
                    infowindow.open(map, marker1);
                }
            })(marker1))
            ;



        }
    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDZ_CL_bAA7VK5OVfdkZNRSF8s7qEkcPj0&callback=initMap">
</script>
</body>
</html>