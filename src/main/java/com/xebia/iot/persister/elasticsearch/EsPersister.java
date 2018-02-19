package com.xebia.iot.persister.elasticsearch;

import com.xebia.iot.persister.Persister;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class EsPersister extends Persister {

    private EsPersisterInfo persisterInfo;
    private TransportClient client;
    private static int docNum = 0;

    public EsPersister(EsPersisterInfo persisterInfo) {
        this.persisterInfo = persisterInfo;
        initClient();
    }

    private void initClient() {
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY);
            for(int i=0; i<persisterInfo.getEsClusterHost().length; i++)
                client.addTransportAddress(
                        new TransportAddress(InetAddress.getByName(
                                persisterInfo.getEsClusterHost()[i]),
                                persisterInfo.getEsClusterPort()[i]
                        )
                );
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void persiste(String data) {
        try {
            docNum++;
            client.prepareIndex(
                    persisterInfo.getIndexName(),
                    persisterInfo.getDocumentTypeName(),
                    Integer.toString(docNum))
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("message", data)
                            .endObject()
                    )
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        client.close();
    }
}
