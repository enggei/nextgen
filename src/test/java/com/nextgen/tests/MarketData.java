package com.nextgen.tests;

public class MarketData {

	long timestamp = 0;
	String instrument;
	int bid = 0, offer = 0;
	long volume = 0;

	public MarketData() {
	}

	public MarketData(long timestamp, String instrument, int bid, int offer, long volume) {
		this.timestamp = timestamp;
		this.instrument = instrument;
		this.bid = bid;
		this.offer = offer;
		this.volume = volume;
	}

	public int getBid() {
		return bid;
	}

	public MarketData setBid(int bid) {
		this.bid = bid;
		return this;
	}

	public String getInstrument() {
		return instrument;
	}

	public MarketData setInstrument(String instrument) {
		this.instrument = instrument;
		return this;
	}

	public int getOffer() {
		return offer;
	}

	public MarketData setOffer(int offer) {
		this.offer = offer;
		return this;
	}

	public long getVolume() {
		return volume;
	}

	public MarketData setVolume(long volume) {
		this.volume = volume;
		return this;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public MarketData setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	@Override
	public String toString() {
		return "{ \"t\": " + timestamp + " \", i\": \"" + instrument  + "\", \"b\": " + bid + ", \"o\": " + offer + ", \"v\": "  + volume + "}";
	}
}
