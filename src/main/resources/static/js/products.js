const productData1 = [{
    id: 1,
    name: "Product1",
    price: 86,
    photo: "img/square.png"
  },
  {
    id: 2,
    name: "Product2",
    price: 82,
    photo: "img/square.png"
  },
  {
    id: 3,
    name: "Product3",
    price: 81,
    photo: "img/square.png"
  },
  {
    id: 4,
    name: "Product4",
    price: 18,
    photo: "img/square.png"
  },
  {
    id: 5,
    name: "Product5",
    price: 22,
    photo: "img/square.png"
  },
  {
    id: 6,
    name: "Product6",
    price: 26,
    photo: "img/square.png"
  },
  {
    id: 7,
    name: "Product7",
    price: 46,
    photo: "img/square.png"
  },
  {
    id: 8,
    name: "Product8",
    price: 87,
    photo: "img/square.png"
  }
];

const productData2 = [{
    id: 1,
    name: "Product1",
    price: 86,
    photo: "img/square.png"
  },
  {
    id: 2,
    name: "Product2",
    price: 82,
    photo: "img/square.png"
  },
  {
    id: 3,
    name: "Product3",
    price: 81,
    photo: "img/square.png"
  },
  {
    id: 4,
    name: "Product4",
    price: 18,
    photo: "img/square.png"
  },
  {
    id: 5,
    name: "Product5",
    price: 22,
    photo: "img/square.png"
  },
  {
    id: 6,
    name: "Product6",
    price: 26,
    photo: "img/square.png"
  },
  {
    id: 7,
    name: "Product7",
    price: 46,
    photo: "img/square.png"
  },
  {
    id: 8,
    name: "Product8",
    price: 87,
    photo: "img/square.png"
  },
  {
    id: 9,
    name: "Product9",
    price: 92,
    photo: "img/square.png"
  },
  {
    id: 10,
    name: "Product10",
    price: 12,
    photo: "img/square.png"
  }
];

function productTemplate(product) {
  return `

<div class="items">
  <img src="${product.photo}" alt="product">
  <a class="button" href="#popup${product.id}">${product.name}</a>
  <div id="popup${product.id}" class="overlay">
    <div class="popup">
      <a class="close" href="#">&times;</a>
      <div class="content">
        <a>${product.name}</a>
        <b>${product.price} руб.</b>
        <c class="add-to-cart" href="#" data-img="${product.photo}" data-name="${product.name}" data-price="${product.price}">В корзину</c>
        <img src="${product.photo}" alt="product">
      </div>
    </div>
  </div>
</div>
`;
}

document.getElementById("products1").innerHTML = `
${productData1.map(productTemplate).join("")}
`;

document.getElementById("products2").innerHTML = `
${productData2.map(productTemplate).join("")}
`;
