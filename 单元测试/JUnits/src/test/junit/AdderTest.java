package test.junit;

import com.junit.AdderImpl;

import android.annotation.SuppressLint;
import junit.framework.TestCase;

public class AdderTest extends TestCase
{
    private AdderImpl adder;
    
    @Override
    protected void setUp()
        throws Exception
    {
        adder = new AdderImpl();
        super.setUp();
    }
    
    @SuppressLint("NewApi")
    public void testAdd()
    {
        assertEquals(0, adder.add(0, 0));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        adder = null;
        super.tearDown();
    }
}
