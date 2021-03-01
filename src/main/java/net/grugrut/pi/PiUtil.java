package net.grugrut.pi;

public class PiUtil {
	public static String calc(String digit) {
		try {
			return calc(Integer.parseInt(digit));
		} catch (Exception e) {
			// TODO logging
			return "Error";
		}
	}
	
	public static String calc(int digit) {
		if (digit < 1) {
			return "Error";
		}
		
		int x[] = new int[digit];
		int z[] = new int[digit];
		int a=1, b=3, c, d, cnt=0;
		boolean run = true;
		
		for (int i = 0; i < digit; ++i) {
			x[i] = 0;
			z[i] = 0;
		}
		x[1] = 2;
		z[1] = 2;
		
		while (run && (++cnt < 2000000)) {
			d = 0;
			for (int i = digit-1; i > 0; --i) {
				c = z[i] * a + d;
				z[i] = c % 10;
				d = c / 10;
			}
			
			d = 0;
			for (int i = 0; i < digit; ++i) {
				c = z[i] + d * 10;
				z[i] = c / b;
				d = c % b;
			}
			
			run = false;
			for (int i = digit -1; i > 0; --i) {
				c = x[i] + z[i];
				x[i] = c % 10;
				x[i-1] += c / 10;
				if (z[i] > 0) {
					run = true;
				}
			}
			++a;
			b += 2;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digit; ++i) {
			sb.append(x[i]);
		}
		
		return sb.toString();
	}
}
