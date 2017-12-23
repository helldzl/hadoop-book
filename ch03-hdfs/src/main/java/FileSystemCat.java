// cc FileSystemCat Displays files from a Hadoop filesystem on standard output by using the FileSystem directly

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URI;

// vv FileSystemCat
public class FileSystemCat {

    public static void main(String[] args) throws Exception {
        String path = "hdfs://192.168.1.229:9000/user/hadoop/topic-test/model/naiveBayesModel.bin";
        // String uri = args[0];
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(path), conf);
        InputStream in = null;
        try {
            in = fs.open(new Path(path));
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
// ^^ FileSystemCat
