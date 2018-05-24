<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 02-Dec-17
 * Time: 14:20
 */

include_once "pages/_includes/header.inc";
?>
<section id="hero">
    <div id="hero_text">
        <h1>Dubrovnik</h1>
        <h2>Queen of the Adriatic</h2>
    </div>
</section>
<div class="scroll_indicator">
    <i class="fa fa-angle-down"></i>
</div>

<section>
    <h2>About Dubrovnik</h2>
    <p>
        Dubrovnik is a coastal town in the south of Croatia.<br>
        <br>
        One of the most prominent destinations in the Mediterranean area, it is no wonder that it often gets featured in many tourist magazines throught the world!
        <br>
        <br>
        The prosperity of the city was historically based on maritime trade and as the capital of the maritime Republic of Ragusa it became notable for its wealth and skilled diplomacy.
        <br>
        <br>
        All of this history gives Dubrovnik a great variety of places to visit, and here you can find some of the best ones!
    </p>
    <h3>Origins and history</h3>
    <p>The story goes that Dubrovnik (or Ragusa as it was called at that time) was founded by Slavic settlement that merged with refugees from Epidaurum.</p>
    <p>As the time went, those settlers filled the canal between a small island and the main settlement in order to connect the city.</p>
    <p>That canal is called Stradun today, also known as the main street in the Old Town.</p>
    <p>The Republic of Ragusa swore to nominal vassalage to many powers of that day (from Kingdom of Hungary, Ottoman Empire and even the Austrian Empire!) but it still remained de facto an independent state until the Napoleonic wars when France finally ended the proud history of independent Ragusa.</p>
    <h3>Legacy</h3>
    <p>Throught its history, the Republic of Ragusa produced many extraordinary people such as Marino Ghetaldi, a famous mathemathician and notable physicist Rudjer Boskovic!</p>
    <p>Even today, Dubrovnik prides itself on producing great waterpolo players!</p>
</section>

<section>
    <div id="loc">
        <p id="lat">42.6493504</p>
        <p id="lng">18.0864078</p>
        <p id="zoom">4</p>
    </div>

    <h2>Where is Dubrovnik?</h2>
    <div id="map">

    </div>
</section>

<section>
    <h2>Gallery</h2>
    <!-- DIV CONTAINING GALLERY ROWS   -->
    <div class="gallery_container">

        <!--DIV DEFINING ROW  -->
        <div class="gallery_row">
            <div class="gallery_element" onclick="showFull('<?php echo $imagePath; ?>','index',1)">
                <div class="gallery_picture">
                    <img src="media/index/thumbs/1.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>View from Minceta Tower</p>
                </div>
            </div>
            <div class="gallery_element" onclick="showFull('<?php echo $imagePath; ?>','index',2)">
                <div class="gallery_picture">
                    <img src="media/index/thumbs/2.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>Dubrovnik at night</p>
                </div>
            </div>
        </div>

        <!--DIV DEFINING ROW  -->
        <div class="gallery_row">
            <div class="gallery_element" onclick="showFull('<?php echo $imagePath; ?>','index',3)">
                <div class="gallery_picture">
                    <img src="media/index/thumbs/3.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>View from Srdj Mountain</p>
                </div>
            </div>
            <div class="gallery_element" onclick="showFull('<?php echo $imagePath; ?>','index',4)">
                <div class="gallery_picture">
                    <img src="media/index/thumbs/4.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>View from Fort Lovrjenac</p>
                </div>
            </div>
        </div>


    </div>
</section>

<?php
include_once "pages/_includes/footer.inc";
?>