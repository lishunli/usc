package cn.jayslong.weibo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDll
{
	private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

	void copyDll() throws Exception
	{
		InputStream in = this.getClass().getClassLoader()
				.getResourceAsStream("bin/lib/sqlite_jni.dll");
		File file2 = new File("sqlite_jni.dll");
		FileOutputStream out = new FileOutputStream(file2);
		copy(in, out);
		in.close();
		out.close();
	}

	private static void copy(InputStream input, OutputStream output)
			throws IOException
	{
		byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
		int n = 0;
		while (-1 != (n = input.read(buffer)))
		{
			output.write(buffer, 0, n);
		}
	}
}
