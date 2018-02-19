package com.xebia.iot.persister;

import org.elasticsearch.test.ESIntegTestCase;
import org.junit.Test;

@ESIntegTestCase.ClusterScope(scope = ESIntegTestCase.Scope.SUITE, numDataNodes = 1)
public class EsPersisterTest extends ESIntegTestCase {
    @Test
    public void test() {
        assertTrue(true);
    }
}
