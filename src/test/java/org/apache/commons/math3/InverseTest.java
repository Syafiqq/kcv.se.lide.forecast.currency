package org.apache.commons.math3;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.util.FastMath;
import org.junit.Test;

/**
 * Created by Muhammad Syafiq on 10/17/2016.
 * Email : Syafiq.rezpector@gmail.com
 * GitHub : Syafiqq
 */
public class InverseTest
{
    @Test public void testMatrix_001()
    {
        final int  nSize = 355 * 3;
        double[][] m     = new double[nSize][nSize];
        for(int i = -1, is = m.length; ++i < is; )
        {
            for(int j = -1, js = m[i].length; ++j < js; )
            {
                m[i][j] = (i + j + 1) * FastMath.random();
            }
        }
        long time = System.currentTimeMillis();
        new LUDecomposition(MatrixUtils.createRealMatrix(m)).getSolver().getInverse();
        time = System.currentTimeMillis() - time;
        long days = TimeUnit.MILLISECONDS.toDays(time);
        time -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(time);
        time -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
        time -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
        time -= TimeUnit.SECONDS.toMillis(seconds);
        System.out.printf(Locale.getDefault(), "%02d %02d:%02d:%02d.%03d", days, hours, minutes, seconds, time);
    }
}
