import React, { useState, useEffect } from "react";

function App() {
  const [products, setProducts] = useState([]);
  const [name, setName] = useState("");

  // 加载产品列表
  const loadProducts = async () => {
    const res = await fetch("http://localhost:8080/api/products");
    const data = await res.json();
    setProducts(data);
  };

  // 添加产品
  const addProduct = async () => {
    await fetch("http://localhost:8080/api/products", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name }),
    });
    setName("");
    loadProducts();
  };

  // 删除产品
  const deleteProduct = async (id) => {
    await fetch(`http://localhost:8080/api/products/${id}`, {
      method: "DELETE",
    });
    loadProducts();
  };

  useEffect(() => {
    loadProducts();
  }, []);

  return (
    <div style={{ margin: "2rem" }}>
      <h1>MonsterShop 产品管理</h1>

      <input
        value={name}
        onChange={(e) => setName(e.target.value)}
        placeholder="输入产品名称"
      />
      <button onClick={addProduct}>添加</button>

      <ul>
        {products.map((p) => (
          <li key={p.id}>
            {p.name}{" "}
            <button onClick={() => deleteProduct(p.id)}>删除</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
