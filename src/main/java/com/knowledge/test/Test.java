package com.knowledge.test;

import com.knowledge.timeline.TimelineServices;

public class Test {
	@org.junit.Test
	public void jsonTimeline() {
		TimelineServices services = new TimelineServices();
		services.findEntityById("6a9416e6-749b-4641-bdf2-ccaae47c61d2");
	}
}
