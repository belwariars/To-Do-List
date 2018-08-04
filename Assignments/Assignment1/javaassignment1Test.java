import com.org.calculatetax.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class javaassignment1Test {

   // private static final double DELTA = 1e-15;


    @Test
    public void ManufacturedProducts() throws Exception{

        TotalPriceManufactured totalPriceManufactured = new TotalPriceManufactured();
        assertEquals(22.95, totalPriceManufactured.tax(20), 0.0f);

    }

    @Test
    public void RawProducts() throws Exception{

        TotalPriceRaw totalPriceRaw = new TotalPriceRaw();
        assertEquals(2.5,totalPriceRaw.tax(20), 0.0f);

    }

    @Test
    public void ImportedProducts() throws Exception{

        TotalPriceImported totalPriceImported = new TotalPriceImported();
        assertEquals(5.2, totalPriceImported.tax(20), 0.0f);

    }

    @Test
    public void checkRawType() throws Exception{

        BaseProduct baseProduct = FactoryProduct.baseProduct(2, "Tomato", 9, "raw");
        if (baseProduct instanceof RawProducts) {
            assert true;
        } else {
            assert false;
        }
    }

    @Test
    public void checkManufacType() throws Exception{

        BaseProduct baseProduct = FactoryProduct.baseProduct(2, "chilli", 9, "manufactured");
        if (baseProduct instanceof ManufacturedProducts) {
            assert true;
        } else {
            assert false;
        }
    }

    @Test
    public void checkImportedType() throws Exception{

        BaseProduct baseProduct = FactoryProduct.baseProduct(2, "potato", 9, "imported");
        if (baseProduct instanceof ImportedProducts) {
            assert true;
        } else {
            assert false;
        }
    }


}