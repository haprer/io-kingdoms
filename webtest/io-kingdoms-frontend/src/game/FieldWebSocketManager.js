

/**
 * This class contains the main websocket for game field play data
 */
export default class FieldWebSocketManager {

    static instance;

    constructor() {
        if (FieldWebSocketManager.instance) { 
            return FieldWebSocketManager.instance;
        } else { 
            FieldWebSocketManager.instance = this; 
            this.connect();
        }
    }

    /**
     * 
     * @returns True iff this socket is instantiated and connected
     */
    isActive() { 

        return (FieldWebSocketManager.instance && this.socket.readyState === WebSocket.OPEN);
    }

    connect() {
        //TODO: Change address and project structure for deployment 
        this.socket = new WebSocket('ws://127.0.0.1:8080/ws');

        this.socket.onopen = () => {
            console.log("WebSocket opened");
            this.socket.send("Hello Server");
        }

        this.socket.onmessage = (e) => {
            console.log("Message received from : ", e.source);
            // You can broadcast the message to the scene using a custom event
        }

        this.socket.onclose = () => {
            console.log("WebSocket closed");
        }
    }

    sendMessage(message) {
        if (this.socket && this.socket.readyState === WebSocket.OPEN) {
            this.socket.send(message);
        }
    }
}
