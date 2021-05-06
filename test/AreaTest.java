import com.company.Point;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AreaTest {
    private Point point;

    @Before
    public void create() {
        point = new Point(0, 0);
    }

    @After
    public void resetPoint() {
        point = null;
    }

    @Test
    public void topLeft() {
        point.setOwner("Egor");
        point.setR(5);

        for (double i = -2.5; i <= 0; i += 0.01) {
            for (double j = 0; j <= 5; j += 0.01) {
                point.setX(i);
                point.setY(j);
                point.check();
                assertEquals(point.toString(), "Owner: " + "Egor" + " has a point X: " + i + " Y: " + j + " Result: " + "True");
            }
        }
    }

    @Test
    public void topLeftLeft() {
        point.setOwner("FirstOwner");
        point.setR(5);

        for (double i = -7; i <= -3; i += 0.001) {
            for (double j = 1; j <= 7; j += 0.001) {
                point.setX(i);
                point.setY(j);
                point.check();
                assertEquals(point.toString(), "Owner: " + "FirstOwner" + " has a point X: " + i + " Y: " + j + " Result: " + "False");
            }
        }
    }

    @Test
    public void downLeftLeft() {
        point.setOwner("Vova");
        point.setR(7);

        for (double i = -20; i <= -8; i += 0.001) {
            for (double j = 0; j <= 2; j += 0.001) {
                point.setX(i);
                point.setY(j);
                point.check();
                assertEquals(point.toString(), "Owner: " + "Vova" + " has a point X: " + i + " Y: " + j + " Result: " + "False");
            }
        }
    }

    @Test
    public void downLeft() {
        point.setOwner("SecondOwner");
        point.setR(3);

        for (double i = -3; i <= 0; i += 0.01) {
            for (double j = -3; j <= 0; j += 0.01) {
                if (i * i + j * j <= 9) {
                    point.setX(i);
                    point.setY(j);
                    point.check();
                    assertEquals(point.toString(), "Owner: " + "SecondOwner" + " has a point X: " + i + " Y: " + j + " Result: " + "True");
                }
            }
        }
    }

    @Test
    public void downRight() {
        point.setOwner("FirstOwner");
        point.setR(5);

        for (double i = 0; i <= 1; i += 0.001) {
            for (double j = -3; j <= 0; j += 0.001) {
                if (j - 2 * i >= -5) {
                    point.setX(i);
                    point.setY(j);
                    point.check();
                    assertEquals(point.toString(), "Owner: " + "FirstOwner" + " has a point X: " + i + " Y: " + j + " Result: " + "True");
                }
            }
        }
    }

    @Test
    public void downRightRight() {
        point.setOwner("Kek");
        point.setR(50);

        for (double i = 53; i <= 75; i += 0.001) {
            for (double j = 0; j <= 1; j += 0.001) {
                point.setX(i);
                point.setY(j);
                point.check();
                assertEquals(point.toString(), "Owner: " + "Kek" + " has a point X: " + i + " Y: " + j + " Result: " + "False");
            }
        }
    }


    @Test
    public void border() {
        point.setOwner("sss");
        point.setR(5);
        point.setX(0);
        point.setY(5);
        point.check();
        assertEquals(point.toString(), "Owner: " + "sss" + " has a point X: " + (double) 0 + " Y: " + (double) 5 + " Result: " + "True");

        point.setX(-2.5);
        point.setY(5);
        point.check();
        assertEquals(point.toString(), "Owner: " + "sss" + " has a point X: " + -2.5 + " Y: " + (double) 5 + " Result: " + "True");

        point.setX(-2.5);
        point.setY(0);
        point.check();
        assertEquals(point.toString(), "Owner: " + "sss" + " has a point X: " + -2.5 + " Y: " + (double) 0 + " Result: " + "True");

        point.setX(-3);
        point.setY(0);
        point.check();
        assertEquals(point.toString(), "Owner: " + "sss" + " has a point X: " + (double) -3 + " Y: " + (double) 0 + " Result: " + "True");

        point.setX(-5);
        point.setY(0);
        point.check();
        assertEquals(point.toString(), "Owner: " + "sss" + " has a point X: " + (double) -5 + " Y: " + (double) 0 + " Result: " + "True");

        point.setX(0);
        point.setY(-5);
        point.check();
        assertEquals(point.toString(), "Owner: " + "sss" + " has a point X: " + (double) 0 + " Y: " + (double) -5 + " Result: " + "True");

        point.setX(2.5);
        point.setY(0);
        point.check();
        assertEquals(point.toString(), "Owner: " + "sss" + " has a point X: " + 2.5 + " Y: " + (double) 0 + " Result: " + "True");

        point.setX(0);
        point.setY(0);
        point.check();
        assertEquals(point.toString(), "Owner: " + "sss" + " has a point X: " + (double) 0 + " Y: " + (double) 0 + " Result: " + "True");
    }


    @Test(timeout = 100)
    public void nullResInPoint() {
        assertNull(point.getRes());
        assertNull(point.getOwner());
    }

    @Test(expected = NullPointerException.class)
    public void nullRInPoint() {
        point.setR(-1);
    }

    @Test(expected = NullPointerException.class)
    public void nullInPoint() {
        point.setR(0);
    }

    @Test
    public void randomPoint() {
        String str;
        point.setOwner("sss");
        int x, y, r;
        for (int i = 0; i < 1000; i++) {
            x = (int) (Math.random() * 50);
            y = (int) (Math.random() * 50);
            r = (int) (Math.random() * 100 + 1);
            point.setX(x);
            point.setY(y);
            point.setR(r);
            if ((x * x + y * y <= r * r && x <= 0 && y <= 0) ||
                    (y - 2 * x >= -r && x >= 0 && y <= 0) ||
                    (y <= r && x >= -r / 2 && x <= 0 && y >= 0)) {
                str = "Owner: " + "sss" + " has a point X: " + (double) x + " Y: " + (double) y + " Result: " + "True";
            } else {
                str = "Owner: " + "sss" + " has a point X: " + (double) x + " Y: " + (double) y + " Result: " + "False";
            }
            point.check();
            assertEquals(point.toString(), str);
        }
    }
}
