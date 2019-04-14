package application.chunks;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests.
 */
final class RadarTest {

    /**
     * A case where center is located at (0, 0).
     */
    @Test
    public void radarShouldBeSquareWhere0By0IsCenter() {
        final List<Point> expected = new ArrayList<>();
        expected.add(new Point(-1, -1));
        expected.add(new Point(0, -1));
        expected.add(new Point(1, -1));
        expected.add(new Point(-1, 0));
        expected.add(new Point(0, 0));
        expected.add(new Point(1, 0));
        expected.add(new Point(-1, 1));
        expected.add(new Point(0, 1));
        expected.add(new Point(1, 1));

        final int compassX = 0;
        final int compassY = 0;
        final int radarHalfLength = 1;

        MatcherAssert.assertThat(
            new Radar(
                new FakeCompass(compassX, compassY),
                radarHalfLength
            ).chunkPositionsAroundPlayer(),
            CoreMatchers.equalTo(expected)
        );
    }

    /**
     * A case where center is located at (-1, -1).
     */
    @Test
    public void radarShouldBeSquareWhereMinus1By1IsCenter() {
        final List<Point> expected = new ArrayList<>();
        // @checkstyle MagicNumber (9 lines)
        expected.add(new Point(-2, 0));
        expected.add(new Point(-1, 0));
        expected.add(new Point(0, 0));
        expected.add(new Point(-2, 1));
        expected.add(new Point(-1, 1));
        expected.add(new Point(0, 1));
        expected.add(new Point(-2, 2));
        expected.add(new Point(-1, 2));
        expected.add(new Point(0, 2));

        final int compassX = -1;
        final int compassY = 1;
        final int radarHalfLength = 1;

        MatcherAssert.assertThat(
            new Radar(
                new FakeCompass(compassX, compassY),
                radarHalfLength
            ).chunkPositionsAroundPlayer(),
            CoreMatchers.equalTo(expected)
        );
    }
}
