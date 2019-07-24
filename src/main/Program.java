import com.drew.imaging.mp4.Mp4MetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import lib.FeatureExtractorFixedFeaturesKnowledgeBasedMp4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Program {
    public static void main(String[] args) throws IOException, ImageProcessingException {
        String path = "C:\\Users\\ttzafrir\\Desktop\\test_b_vid.mp4";
        FeatureExtractorFixedFeaturesKnowledgeBasedMp4 test = new FeatureExtractorFixedFeaturesKnowledgeBasedMp4();
        FeatureExtractorFixedFeaturesKnowledgeBasedMp4.extractFeaturesFromSingleElement(path);
        printElements(path);
    }

    private static void printElements(String elementFilePath) throws IOException, ImageProcessingException {
        InputStream file = new FileInputStream(elementFilePath);
        Metadata metadata = Mp4MetadataReader.readMetadata(file);

        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                System.out.format("[%s] - %s = %s",
                        directory.getName(), tag.getTagName(), tag.getDescription());
                System.out.println();
            }
            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.format("ERROR: %s", error);
                }
            }
        }
    }
}
