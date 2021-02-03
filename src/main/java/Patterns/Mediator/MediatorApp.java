package Patterns.Mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация очень простая. У нас есть несколько Clients, которые хранят ссылку на Mediator. Самый лучший пример - чат
 */
public class MediatorApp {
	public static void main(String[] args) {
		Chat chat = new Chat();

		Client client1 = new ChatMember(chat, "Stas");
		Client client2 = new ChatMember(chat, "Katya");

		chat.addClient(client1);
		chat.addClient(client2);

		client1.broadcastEvent();
		client2.broadcastEvent();
	}
}

abstract class Meditator {
	List<Client> clients;

	void notifyClients() {
		for (Client client : clients) {
			client.handleEvent();
		}
	}

	void receiveMessage(Client client) {
		System.out.println("Message received from: " + client.getName());
		notifyClients();
	}
}

class Chat extends Meditator {
	public Chat() {
		this.clients = new ArrayList<>();
	}

	public void addClient(Client client){
		clients.add(client);
	}

	public void removeClient(Client client){
		clients.remove(client);
	}
}

abstract class Client {
	private Meditator chat;
	private String name;

	public Client(Meditator chat) {
		this.chat = chat;
	}

	public Client(Meditator chat, String name) {
		this.chat = chat;
		this.name = name;
	}

	public Meditator getChat() {
		return chat;
	}

	public void setChat(Meditator chat) {
		this.chat = chat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	void handleEvent() {
		System.out.println("Сообщение получено клиентом " + name);
	}

	void broadcastEvent() {
		chat.receiveMessage(this);
	}
}

class ChatMember extends Client {
	public ChatMember(Meditator chat) {
		super(chat);
	}

	public ChatMember(Meditator chat, String name) {
		super(chat, name);
	}
}



