package dtu.roborally.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageHandler {

    private static ArrayList<Image> images = new ArrayList<>();
    private static ArrayList<String> ids = new ArrayList<>();

    public static ImageView loadFile(String Location, String id, int ImageHeight, int ImageWidth){
        ImageView IV;

        if(ids.contains(id)) {
            int index = ids.indexOf(id);
            IV = new ImageView(images.get(index));
        } else {
            FileInputStream input = null;
            try {
                input = new FileInputStream(Location);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Image image = new Image(input);
            images.add(image);
            ids.add(id);
            IV = new ImageView(image);
        }
        IV.setFitHeight(ImageHeight);
        IV.setFitWidth(ImageWidth);
        return IV;
    }
}