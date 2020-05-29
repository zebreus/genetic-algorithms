package MainClasses;

import Enums.VisualizerMethods;
import Visualization.VideoCreator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String propertyPath = "./src/main/resources/genetic.properties";
        Config config = new Config(propertyPath);

        int[] protein = Examples.convertStringToIntArray(Examples.SEQ36);
        GeneticAlgorithm ga = new GeneticAlgorithm(protein);
        ga.simulateGenerations();

        // Create a new video if possible and desired
        boolean imagesRefreshed = Arrays.asList(Config.VISUALIZERS).contains(VisualizerMethods.Image);
        boolean videoEnabled = Arrays.asList(Config.VISUALIZERS).contains(VisualizerMethods.Video);
        if (imagesRefreshed && videoEnabled){
            VideoCreator.createVideo(Config.IMAGE_SEQUENCE_PATH, Config.VIDEO_PATH_AND_FILE,
                    Config.IMAGE_FPS, Config.IMAGES_TO_FPS_INCREASE, Config.IMAGE_FPS_MAX,
                    ga.getMaxH(), ga.getMaxW(), Config.ZOOM);
        }
    }
}
