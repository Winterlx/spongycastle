package org.spongycastle.pqc.crypto.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.spongycastle.util.test.SimpleTestResult;

public class AllTests
    extends TestCase
{   
    public void testCrypto()
    {   
        org.spongycastle.util.test.Test[] tests = RegressionTest.tests;
        
        for (int i = 0; i != tests.length; i++)
        {
            org.spongycastle.util.test.Test test = tests[i];
            SimpleTestResult  result = (SimpleTestResult) test.perform();

            if (!result.isSuccessful())
            {
                System.out.println("Test "+test+" Result "+result);
                fail(result.toString());
            }
        }
    }

    public static void main (String[] args)
    {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite()
    {
        TestSuite suite = new TestSuite("Lightweight PQ Crypto Tests");
        
        suite.addTestSuite(AllTests.class);
        suite.addTestSuite(BitStringTest.class);
        suite.addTestSuite(EncryptionKeyTest.class);
        suite.addTestSuite(NTRUEncryptionParametersTest.class);
        suite.addTestSuite(NTRUEncryptTest.class);
        suite.addTestSuite(NTRUSignatureParametersTest.class);
        suite.addTestSuite(NTRUSignatureKeyTest.class);
        suite.addTestSuite(NTRUSignerTest.class);
        suite.addTestSuite(NTRUSigningParametersTest.class);

        return suite;
    }
}