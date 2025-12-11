# 📝 Notes App (Kotlin + Firebase)

A simple and modern **Notes Application** built using **Kotlin**, **Firebase Authentication**, **Firebase Realtime Database**, and **XML UI**.
This app allows users to **Sign Up, Login, Add Notes, Update Notes, and Delete Notes** in real-time.

---

## 🚀 Features

* 🔐 **User Authentication** (Login & Sign-Up using Firebase Auth)
* 📝 **Create Notes** (Title + Description)
* ✏ **Update Notes** with custom dialog
* ❌ **Delete Notes** instantly
* ☁ **Real-time Firebase Sync**
* 🎨 **Modern UI using XML + ViewBinding**
* ♻️ **RecyclerView** for listing notes
* 📱 Clean and responsive design

---

## 🛠 Tech Stack

| Component          | Technology                 |
| ------------------ | -------------------------- |
| **Language**       | Kotlin                     |
| **UI Design**      | XML, ConstraintLayout      |
| **Backend**        | Firebase Realtime Database |
| **Authentication** | Firebase Auth              |
| **Architecture**   | ViewBinding + RecyclerView |

---

## 📂 Project Structure

```
📁 NotesApp
   ├── 🧩 Activities
   │     ├── LoginActivity.kt
   │     ├── SignUpActivity.kt
   │     ├── AddNote.kt
   │     └── AllNotes.kt
   │
   ├── 🎨 Adapter
   │     └── NoteAdapter.kt
   │
   ├── 📄 Model
   │     └── NoteItem.kt
   │
   ├── 🗂 XML Layouts
   │     ├── activity_login.xml
   │     ├── activity_sign_up.xml
   │     ├── activity_add_note.xml
   │     ├── activity_all_notes.xml
   │     ├── note_item.xml
   │     └── dialog_update_note.xml
   │
   └── 🔥 Firebase Auth + Realtime Database
```

---

## ⚙️ Installation & Setup

1️⃣ Clone the repository

```bash
git clone https://github.com/Annada234/NotesApp.git
```

2️⃣ Open in **Android Studio**

3️⃣ Add your own **google-services.json** file

4️⃣ Enable:

* Firebase Authentication (Email/Password)
* Firebase Realtime Database

5️⃣ Run the project on Emulator or Physical Device

```bash
Shift + F10 (Windows)  
Control + R (Mac)
```

---

## 🎯 How It Works

### 🔹 **Sign-Up / Login**

Users can register with email and password.

### 🔹 **Add Note**

Users can create new notes with a title and description.

### 🔹 **Update Note**

Clicking the update button opens a custom dialog to edit the note.

### 🔹 **Delete Note**

Deletes the selected note from Firebase.

---

## 📸 Screenshots
**Sign Up Page**
<img width="540" height="1204" alt="image" src="https://github.com/user-attachments/assets/f61412f1-fd59-4e65-b15a-5103d42211b2" />

**Sign Up Screen**
<img width="540" height="1204" alt="image" src="https://github.com/user-attachments/assets/c9ff81ee-d385-4499-8c27-d8216aefbbb7" />


<img width="540" height="1204" alt="image" src="https://github.com/user-attachments/assets/9f69c3f9-afb7-47fc-8b7d-12ab6374b6b5" />


<img width="540" height="1204" alt="image" src="https://github.com/user-attachments/assets/efed2396-7e1b-4656-bb52-b83642309390" />

* Add dark mode
* Add search functionality
* Add note categories & colors
* Cloud backup and offline support
