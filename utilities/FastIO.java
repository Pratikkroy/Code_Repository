package utilities;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class FastIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

class ScanReader 
{
    private byte[] buf = new byte[4 * 1024];
    private int index;
    private BufferedInputStream in;
    private int total;
    
    public ScanReader(InputStream inputStream) 
    {
        in = new BufferedInputStream(inputStream);
    }
    
    private int scan() {
        if (index >= total) {
            index = 0;
            try {
                total = in.read(buf);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (total <= 0) return -1;
        }
        return buf[index++];
    }
    public int scanInt() {
        int integer = 0;
        int n = scan();
        while (isWhiteSpace(n)) n = scan();
        int neg = 1;
        if (n == '-') {
            neg = -1;
            n = scan();
        }
        while (!isWhiteSpace(n)) {
            if (n >= '0' && n <= '9') {
                integer *= 10;
                integer += n - '0';
                n = scan();
            }
        }
        return neg * integer;
    }
    private boolean isWhiteSpace(int n) {
        if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
        else return false;
    }
    public void scanInt(int[] A, int size) {
        for (int i = 0; i < size; i++) A[i] = scanInt();
    }

    public long scanLong() {
            long integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                }
            }
            return neg * integer;
        }
}

class Print
{
    private final BufferedWriter bw;
    public Print()
    {
        this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public void print(Object object)throws IOException
    {
        bw.append(""+object);
    }
    public void println(Object object)throws IOException
    {
        print(object);
        bw.append("\n");
    }
    public void close()throws IOException
    {
        bw.close();
    }
}

