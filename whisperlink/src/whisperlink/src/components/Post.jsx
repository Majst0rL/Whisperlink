import React, { useState } from "react";
import { Link } from "react-router-dom";

const Post = ({ id: initialId, user: initialUser, text: initialText, date: initialDate, time: initialTime }) => {
  const [id, setId] = useState(initialId || "");
  const [user, setUser] = useState(initialUser || "");
  const [text, setText] = useState(initialText || "");
  const [date, setDate] = useState(initialDate || "");
  const [time, setTime] = useState(initialTime || "");
  const [location, setLocation] = useState(""); // Dodajte potrebne podatke

  const handleEditClick = () => {
    // Logika za urejanje objave, če je potrebno
    console.log("Editing post:", id);
  };

  return (
    <div>
      <h1>Post Details</h1>
      <p>ID: {id}</p>
      <p>User: {user}</p>
      <p>Text: {text}</p>
      <p>Date: {date}</p>
      <p>Time: {time}</p>
      {/* Dodajte druge podatke po potrebi */}
      <Link to={`/posts/${id}/edit`} onClick={handleEditClick}>
        Edit Post
      </Link>
    </div>
  );
};

export default Post;
