# J.A.R.V.I.S. Mobile + Desktop Foundation

## What works in this build
- Responsive futuristic JARVIS HUD interface.
- Local date, clock, online/offline status and battery level where supported.
- Browser speech recognition where supported (Chrome on Android is recommended).
- Speech synthesis / spoken test response.
- Local language and backend URL settings.
- Chat UI that clearly reports when AI is not configured.
- Optional backend connection contract: `POST {BACKEND_URL}/chat` with JSON `{ "message": "...", "language": "en-IN" }`; expected JSON response `{ "reply": "..." }`.

## Important limitations
This is a real mobile-ready interface foundation, not a connected AI assistant yet. No AI API provider was selected and no API key is included. Do not put a private API key into frontend JavaScript. Add a secure backend that stores the key server-side.
Mobile browsers cannot freely control other phone apps or Windows. Those features require native Android permissions or a Windows companion application.

## Run on Android
1. Extract the ZIP.
2. Upload the folder to a static hosting service that gives you an HTTPS URL (for example GitHub Pages or another static host).
3. Open the HTTPS URL in Chrome on Android.
4. Allow microphone permission when prompted.
5. Use Chrome menu > Add to Home screen / Install app if offered.
6. For voice recognition, use Chrome and check microphone permission in site settings.

Opening `index.html` directly from a file manager may limit microphone and PWA features. HTTPS hosting is recommended.

## Backend contract
Create a backend endpoint `POST /chat`.
Request:
```json
{"message":"Hello JARVIS","language":"en-IN"}
```
Response:
```json
{"reply":"Hello. How can I help?"}
```
The backend must validate input, authenticate requests as appropriate, rate-limit usage, and keep provider API credentials on the server. This frontend currently does not include a provider adapter.

## Files
- `index.html`: responsive interface and browser voice functions
- `manifest.webmanifest`: installable app metadata
- `sw.js`: basic offline shell cache
- `README.md`: setup and limitations
