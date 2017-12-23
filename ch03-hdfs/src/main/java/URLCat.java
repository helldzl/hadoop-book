// cc URLCat Displays files from a Hadoop filesystem on standard output using a URLStreamHandler

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URL;

// vv URLCat
public class URLCat {

    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) throws Exception {
        String path = "hdfs://192.168.1.229:9000/user/hadoop/topic-test/model/naiveBayesModel.bin";
        InputStream in = null;
        try {
            in = new URL(path).openStream();
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
// ^^ URLCat
