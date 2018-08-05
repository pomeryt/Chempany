package application.page.title;

import plain.contract.entity.VoidTaskOfEntity;
import plain.contract.event.PlainEvent;

public final class TpOnExit implements VoidTaskOfEntity<TitlePage> {

	public TpOnExit(final PlainEvent... events) {
		this.events = events;
	}
	
	@Override
	public void handle(final TitlePage page) {
		for (PlainEvent event: events) {
			page.exitEvents.add(event);
		}
	}
	
	private final PlainEvent[] events;
}
