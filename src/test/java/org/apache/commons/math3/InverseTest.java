package org.apache.commons.math3;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
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
        final int nSize = 1000;
        double[][] m = new double[nSize][nSize];
        for(int i = -1, is = m.length; ++i < is;)
        {
            for(int j = -1, js = m[i].length; ++j < js;)
            {
                m[i][j] = (i + j + 1) * FastMath.random();
            }
        }
        RealMatrix pInverse = new LUDecomposition(MatrixUtils.createRealMatrix(m)).getSolver().getInverse();
    }
}
