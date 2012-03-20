package me.shenfeng.http.codec;

import java.io.IOException;
import java.nio.ByteBuffer;

import me.shenfeng.http.codec.HttpMessageDecoder.State;

import org.junit.Before;
import org.junit.Test;

public class HttpResponseDecoderTest {
    private ByteBuffer chunked;
    private ByteBuffer normal;
    private HttpResponseDecoder decoder;

    @Before
    public void setup() throws IOException {
        chunked = ByteBuffer.wrap(Utils.readAll("beta_shield_chunked"));
        normal = ByteBuffer.wrap(Utils.readAll("beta_shield"));
        decoder = new HttpResponseDecoder();
    }

    @Test
    public void testChunked() throws LineTooLargeException, ProtocolException {
        decoder.decode(chunked);
        IHttpResponse resp = decoder.getMessage();
    }

    @Test
    public void testNormal() throws LineTooLargeException, ProtocolException {
        State decode = decoder.decode(chunked);
        IHttpResponse resp = decoder.getMessage();
    }

}