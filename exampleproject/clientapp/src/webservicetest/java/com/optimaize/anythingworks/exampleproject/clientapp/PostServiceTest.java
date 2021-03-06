package com.optimaize.anythingworks.exampleproject.clientapp;

import com.google.common.base.Optional;
import com.google.common.base.Stopwatch;
import com.optimaize.command4j.Command;
import com.optimaize.command4j.CommandExecutor;
import com.optimaize.command4j.Mode;
import com.optimaize.command4j.lang.Duration;
import com.optimaize.anythingworks.exampleproject.clientlib.DemoappRemoteExecutors;
import com.optimaize.anythingworks.exampleproject.ontology.rest.development.post.Circle;
import com.optimaize.anythingworks.exampleproject.ontology.rest.development.post.ComplexObject;
import com.optimaize.anythingworks.exampleproject.clientlib.rest.services.development.post.RestPostCommand;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

/**
 * In order to run these tests, run the Boot class first.
 *
 * @author Fabian Kessler
 */
public class PostServiceTest {

    private final CommandExecutor executor = DemoappRemoteExecutors.get();

    @Test
    public void rest_Post() throws Exception {
        RestPostCommand ping = new RestPostCommand();
        Mode mode = MyModeFactory.debug();
        ComplexObject param = new ComplexObject("nanaäöü", 42, 3.33d, true, ComplexObject.Color.RED, new Circle("blue", 5d), Optional.of("foo"), Optional.<String>absent());
        ComplexObject result = executor.service().submitAndWait(ping, mode, param, Duration.millis(100000)).get();
        assertEquals(result.getString(), param.getString()+"-resultäöü");
        assertEquals(result.getIntNumber(), param.getIntNumber()*2);
        assertEquals(result.getDoubleNumber(), param.getDoubleNumber()*2, 0.0001d);
        assertEquals(result.isYesOrNo(), !param.isYesOrNo());
        assertEquals(result.getColor(), ComplexObject.Color.RED);
        assertEquals(result.getGeometricalFigure().getColor(), "light"+param.getGeometricalFigure().getColor());
        assertTrue(result.getGeometricalFigure() instanceof Circle);
        assertEquals(result.getOptional1().get(), "foobar");
        assertFalse(result.getOptional2().isPresent());

//        stressTest(ping);
    }

    private void stressTest(Command c) throws Exception {
        Mode mode = MyModeFactory.debug();
        Stopwatch time = Stopwatch.createStarted();
        for (int i=0; i<1000; i++) {
            Object result = executor.service().submitAndWait(c, mode, null, Duration.millis(100000)).get();
            assertEquals("pong", result);
        }
        long timeTaken = time.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(timeTaken+"ms");
    }

}
