package com.xebia.iot.persister;

import org.elasticsearch.test.ESIntegTestCase;
import org.junit.Test;

@ESIntegTestCase.ClusterScope(scope = ESIntegTestCase.Scope.TEST, numDataNodes = 0, numClientNodes = 0, transportClientRatio = 0.0,
        autoMinMasterNodes = false)
public class EsPersisterTest extends ESIntegTestCase {

    @Test
    public void test() throws Exception {
        assertTrue(true);
    }
}
