package application.page.title;

import plain.contract.entity.VoidTaskOfEntity;
import plain.contract.event.PlainEvent;

public final class TpOnNew implements VoidTaskOfEntity<TitlePage> {

	public TpOnNew(final PlainEvent... events) {
		this.events = events;
	}
	
	@Override
	public void handle(final TitlePage page) {
		for (PlainEvent event: this.events) {
			page.newEvents.add(event);
		}
	}
	
	private final PlainEvent[] events;
}
