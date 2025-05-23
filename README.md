# GWack-Client-ChatApp

A Java Swing-based GUI chat client built to connect with the GWack messaging server, simulating a Slack-like communication tool. This project combines object-oriented programming, socket networking, and interactive UI design to offer a personalized messaging experience.

## Features

- Connect/disconnect functionality to GWack server
- Real-time messaging using socket communication
- User status selection: Available, Busy, Gone
- Color-coded message customization
- Font styling: Plain, Italic, Bold
- Light and Dark UI themes
- Interactive user list and message display
- Compose and send messages via button or `Enter` key
- Error handling for invalid ports, names, and connections

## Technologies Used

- Java
- Java Swing (GUI)
- Sockets (`java.net.Socket`)
- Input/Output Streams

## How It Works

1. User enters:
   - Display name
   - IP address (e.g., `ssh-cs2113.adamaviv.com`)
   - Port (8886, 8887, or 8888)
2. Upon connection, the GUI fetches members and enables messaging.
3. Users can choose visual customizations (theme, font, color) and status.
4. Messages are sent to the server and reflected in the Messages panel with selected styles.

## UI Highlights

- **Light Mode**: Soft beige and gray tones for a clean look
- **Dark Mode**: Vibrant accents on a dark background
- **Custom Font and Color Options**: Personalize messages with style

## Developer Notes

This project was created with an emphasis on both **functionality and design**. I aimed to make the interface fun and engaging while also fulfilling the technical requirements. There’s room for feature expansion such as emoji support, sound notifications, and improved layout responsiveness.

## How to Run

1. Clone the repository.
2. Compile using `javac GWackClientGUI.java`.
3. Run the program with `java GWackClientGUI`.
4. Ensure the server (`ssh-cs2113.adamaviv.com`) is reachable and running.

## Future Ideas

- Add support for emoji reactions
- Implement a zombie-themed chat filter for fun
- Save chat history locally
- Group channel creation and management

---

### Signed with creativity and care by Issouf Diarrassouba
