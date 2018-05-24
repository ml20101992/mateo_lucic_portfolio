<?php
/**
 * Created by PhpStorm.
 * User: Mateo
 * Date: 02-Dec-17
 * Time: 14:21
 */

include_once "_includes/header.inc";

/** Function used to get the caption data for the gallery
 * @param $id page id
 * @return array    array containing captions
 *
 */
function getCaptionData($id)
{
    $visiting = array("Rector's Palace", "Franciscan Monastery", "City Walls", "Sponza Palace");
    $palace = array("View from the beach", "Interior view", "View from the restaurant", "Indoor pool");
    $libertas = array("View from the outside", "Indoor pool", "View from the restaurant", "Congress Hall");
    $lacroma = array("View from the pool", "View of the recreation center", "Indoor pool", "Interior view");
    $importanne = array("View from the outside", "View of the sea", "Room view", "Room view");
    $imperial = array("View from the outside", "Restaurant", "Imperial at night", "Interior view");
    $excelsior = array("View from the outside", "Interior view", "Ceiling", "Indoor pool");
    $bellevue = array("View from the outside", "View from the pool", "Lounge", "View to the sea");
    $argentina = array("View from the sea", "Gardens", "View from the beach", "Aerial view");

    switch ($id) {
        case 2:
            return $visiting;
        case 3:
            return $argentina;
        case 4:
            return $bellevue;
        case 5:
            return $excelsior;
        case 6:
            return $imperial;
        case 7:
            return $lacroma;
        case 8:
            return $libertas;
        case 9:
            return $importanne;
        case 10:
            return $palace;
        default:
            return array();
    }
}
?>

    <section id="hero">
        <div id="hero_text">
            <?php echo getHeroMessages($conn,$_GET['id'])?>
        </div>
    </section>
    <div class="scroll_indicator">
        <i class="fa fa-angle-down"></i>
    </div>

<?php
populatePage($conn,$_GET['id']);

//add the link grid just for hotels general!
if ($_GET['id'] ==1) {?>

    <!-- JUST FOR GENERAL VISITING PAGE!   -->
    <section>
    <div class="gallery_container">

        <!--DIV DEFINING ROW  -->
        <div class="gallery_row">
            <div class="gallery_element" onclick="redirect(3)">
                <div class="gallery_picture">
                    <img src="../media/argentina/thumbs/1.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>Argentina</p>
                </div>
            </div>
            <div class="gallery_element" onclick="redirect(4)">
                <div class="gallery_picture">
                    <img src="../media/bellevue/thumbs/1.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>Bellevue</p>
                </div>
            </div>
        </div>

        <!--DIV DEFINING ROW  -->
        <div class="gallery_row">
            <div class="gallery_element" onclick="redirect(5)">
                <div class="gallery_picture">
                    <img src="../media/excelsior/thumbs/1.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>Excelsior</p>
                </div>
            </div>
            <div class="gallery_element" onclick="redirect(6)">
                <div class="gallery_picture">
                    <img src="../media/imperial/thumbs/1.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>Imperial</p>
                </div>
            </div>
        </div>

    </div>

    <div class="gallery_container">

        <!--DIV DEFINING ROW  -->
        <div class="gallery_row">
            <div class="gallery_element" onclick="redirect(7)">
                <div class="gallery_picture">
                    <img src="../media/lacroma/thumbs/1.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>Lacroma</p>
                </div>
            </div>
            <div class="gallery_element" onclick="redirect(8)">
                <div class="gallery_picture">
                    <img src="../media/libertas/thumbs/1.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>Libertas Rixos</p>
                </div>
            </div>
        </div>

        <!--DIV DEFINING ROW  -->
        <div class="gallery_row">
            <div class="gallery_element" onclick="redirect(9)">
                <div class="gallery_picture">
                    <img src="../media/importanne/thumbs/1.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>Importanne</p>
                </div>
            </div>
            <div class="gallery_element" onclick="redirect(10)">
                <div class="gallery_picture">
                    <img src="../media/palace/thumbs/1.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p>Palace</p>
                </div>
            </div>
        </div>

    </div>
    </section>


<?php }
if ($_GET['id'] !=1) {
    $captions = getCaptionData($_GET['id']);
?>
<section>
    <h2>Gallery</h2>
    <!-- DIV CONTAINING GALLERY ROWS   -->
    <div class="gallery_container">

        <!--DIV DEFINING ROW  -->
        <div class="gallery_row">
            <div class="gallery_element" onclick="showFull('<?php echo $imagePath; ?>','<?php echo getGalleryFolder($conn,$_GET['id']);?>',1)">
                <div class="gallery_picture">
                    <img src="<?php echo $imagePath; ?>/<?php echo getGalleryFolder($conn,$_GET['id']);?>/thumbs/1.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p><?php echo $captions[0] ?></p>
                </div>
            </div>
            <div class="gallery_element" onclick="showFull('<?php echo $imagePath; ?>','<?php echo getGalleryFolder($conn,$_GET['id']);?>',2)">
                <div class="gallery_picture">
                    <img src="<?php echo $imagePath; ?>/<?php echo getGalleryFolder($conn,$_GET['id']);?>/thumbs/2.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p><?php echo $captions[1] ?></p>
                </div>
            </div>
        </div>

        <!--DIV DEFINING ROW  -->
        <div class="gallery_row">
            <div class="gallery_element" onclick="showFull('<?php echo $imagePath; ?>','<?php echo getGalleryFolder($conn,$_GET['id']);?>',3)">
                <div class="gallery_picture">
                    <img src="<?php echo $imagePath; ?>/<?php echo getGalleryFolder($conn,$_GET['id']);?>/thumbs/3.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p><?php echo $captions[2] ?></p>
                </div>
            </div>
            <div class="gallery_element" onclick="showFull('<?php echo $imagePath; ?>','<?php echo getGalleryFolder($conn,$_GET['id']);?>',4)">
                <div class="gallery_picture">
                    <img src="<?php echo $imagePath; ?>/<?php echo getGalleryFolder($conn,$_GET['id']);?>/thumbs/4.jpg" alt="">
                </div>
                <div class="picture_capt">
                    <p><?php echo $captions[3] ?></p>
                </div>
            </div>
        </div>


    </div>
    </section>
<?php }

include_once "_includes/footer.inc";
?>