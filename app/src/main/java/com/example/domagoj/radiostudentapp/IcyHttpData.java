package com.example.domagoj.radiostudentapp;

import com.example.domagoj.radiostudentapp.util.MyConsumer;

import saschpe.exoplayer2.ext.icy.IcyHttpDataSource;

class IcyHttpData {
    private final MyConsumer<String> consumer;
    private IcyHttpDataSource.IcyHeaders icyHeaders;
    private IcyHttpDataSource.IcyMetadata icyMetadata;
    private String streamTitle = "";

    public IcyHttpData(MyConsumer<String> consumer) {
        this.consumer = consumer;
    }

    public void iceHeader(IcyHttpDataSource.IcyHeaders icyHeaders) {
        this.icyHeaders = icyHeaders;
        // Log.d("XXX", String.format(icyHeaders.toString()));
        acceptStremTitle();
    }

    public void icyMetadata(IcyHttpDataSource.IcyMetadata icyMetadata) {
        this.icyMetadata = icyMetadata;
        // Log.d("XXX", String.format(icyMetadata.toString()));
        acceptStremTitle();
    }

    private void acceptStremTitle() {
        setStreamTitle();
        if (consumer != null) {
            consumer.accept(streamTitle);
        }
    }

    private void setStreamTitle() {
        if (icyMetadata != null) {
            streamTitle = icyMetadata.getStreamTitle();
            icyMetadata = null;
            return;
        }
        if (icyHeaders != null) {
            streamTitle = icyHeaders.getName();
        }
    }

}
