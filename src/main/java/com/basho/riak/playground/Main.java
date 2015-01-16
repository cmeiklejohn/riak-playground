package com.basho.riak.playground;

import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.RiakNode;

import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            RiakCluster cluster = setUpCluster();
            RiakClient client = startRiak(cluster);

            /* start */

            // Do some Riak stuff here

            /* end */

            cluster.shutdown();
        } catch (UnknownHostException e) {
            throw new Exception(e);
        }
    }

    public static RiakCluster setUpCluster() throws UnknownHostException {
        List<RiakNode> nodes = new LinkedList<RiakNode>();
        RiakNode.Builder nodeBuilder = new RiakNode.Builder()
                .withRemoteAddress("127.0.0.1");
        for (int port = 10017; port <= 10037; port += 10) {
            RiakNode node = nodeBuilder.withRemotePort(port).build();
            nodes.add(node);
        }
        return new RiakCluster.Builder(nodes).build();
    }

    public static RiakClient startRiak(RiakCluster cluster) {
        cluster.start();
        return new RiakClient(cluster);
    }
}
