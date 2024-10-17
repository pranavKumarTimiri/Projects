document.getElementById('send-btn').addEventListener('click', sendMessage);

function sendMessage() {
  const userInput = document.getElementById('user-input').value;

  if (userInput.trim() === '') return;

  appendMessage('user-message', userInput);

  // Clear the input after sending
  document.getElementById('user-input').value = '';

  // Simulate a response from the bot
  setTimeout(() => {
    const botResponse = getBotResponse(userInput);
    appendMessage('bot-message', botResponse);
  }, 1000);
}

// Function to append a message to the chat
function appendMessage(className, message) {
  const chatBox = document.getElementById('chat-box');
  const messageDiv = document.createElement('div');
  messageDiv.className = `message ${className}`;
  messageDiv.textContent = message;
  chatBox.appendChild(messageDiv);
  chatBox.scrollTop = chatBox.scrollHeight;
}

// Simple bot logic
function getBotResponse(userInput) {
  userInput = userInput.toLowerCase();

  if (userInput.includes('hello')) {
    return 'Hello! How can I assist you today?';
  } else if (userInput.includes('how are you')) {
    return "I'm just a bot, but I'm doing great!";
  } else if (userInput.includes('your name')) {
    return 'I am a simple chatbot.';
  } else if (userInput.includes('bye')) {
    return 'Goodbye! Have a great day!';
  } else {
    return "Sorry, I don't understand that.";
  }
}
