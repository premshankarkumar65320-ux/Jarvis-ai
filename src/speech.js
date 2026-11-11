import { registerPlugin } from '@capacitor/core';

const SpeechRecognition = registerPlugin('SpeechRecognition');

window.JarvisSpeech = SpeechRecognition;
