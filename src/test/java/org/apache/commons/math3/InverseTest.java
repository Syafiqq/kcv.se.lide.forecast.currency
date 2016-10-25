package org.apache.commons.math3;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.commons.math3.linear.CholeskyDecomposition;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.SingularValueDecomposition;
import org.apache.commons.math3.util.FastMath;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Muhammad Syafiq on 10/17/2016.
 * Email : Syafiq.rezpector@gmail.com
 * GitHub : Syafiqq
 */
public class InverseTest
{
    private double[][] m;

    @Before public void initialization()
    {
        final int  nSize = 355 * 3;
        this.m     = new double[nSize][nSize];
        for(int i = -1, is = m.length; ++i < is; )
        {
            for(int j = -1, js = m[i].length; ++j < js; )
            {
                m[i][j] = (i + j + 1) * FastMath.random();
            }
        }
    }

    @Test public void LUDecompositionTesting()
    {
        long time = System.currentTimeMillis();
        new LUDecomposition(MatrixUtils.createRealMatrix(this.m)).getSolver().getInverse();
        System.out.println(this.parseTime(time));
    }

    @Test public void CholeskyDecompositionTesting()
    {
        long time = System.currentTimeMillis();
        new CholeskyDecomposition(MatrixUtils.createRealMatrix(this.m)).getSolver().getInverse();
        System.out.println(this.parseTime(time));
    }

    @Test public void QRDecompositionTesting()
    {
        long time = System.currentTimeMillis();
        new QRDecomposition(MatrixUtils.createRealMatrix(this.m)).getSolver().getInverse();
        System.out.println(this.parseTime(time));
    }

    @Test public void EDecompositionTesting()
    {
        long time = System.currentTimeMillis();
        new EigenDecomposition(MatrixUtils.createRealMatrix(this.m)).getSolver().getInverse();
        System.out.println(this.parseTime(time));
    }

    @Test public void SVDecompositionTesting()
    {
        long time = System.currentTimeMillis();
        new SingularValueDecomposition(MatrixUtils.createRealMatrix(this.m)).getSolver().getInverse();
        System.out.println(this.parseTime(time));
    }

    private String parseTime(long time)
    {
        time = System.currentTimeMillis() - time;
        long days = TimeUnit.MILLISECONDS.toDays(time);
        time -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(time);
        time -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
        time -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
        time -= TimeUnit.SECONDS.toMillis(seconds);
        return String.format(Locale.getDefault(), "%02d %02d:%02d:%02d.%03d", days, hours, minutes, seconds, time);
    }
}
