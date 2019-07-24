import com.axiosys.bento4.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        String path = "C:/Users/ttzaf/Desktop/Best Samples/48cc1a938e8830c93f87741505cfdd8d41c3bfaeddd0a4b3c154495560a9f4d7";
        AtomList atoms = new AtomList(path);

        if (args.length > 1) {
            Atom atom = AtomUtils.findAtom(atoms, path);
            if (atom != null) {
                System.out.println(atom);
                byte[] payload = atom.getPayload();
                System.out.println(new String(payload));
            }
        } else {
            System.out.println(atoms);
        }
        /*
        File file = new File(path);
        Track[] tracks = file.getMovie().getTracks();
        for (int i=0; i<tracks.length; i++) {
            System.out.println("Track " + tracks[i].getId() + ":");
            System.out.println("  Type: " + tracks[i].getType());
        }
        System.out.println(file.getMovie().getMoovAtom());
        System.out.println("to_string");*/
    }
}
