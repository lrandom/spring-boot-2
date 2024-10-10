Xây dựng trang web bán hàng: bán mọi thứ

User(id,email,password,fullname,phone,address,role[1.2])
Categories(id, name, description, created_at, updated_at)
Products(id, name, price, discount, description, categoryId, brandId, rate_avg,created_at,updated_at)
ProductImages(id, productId, path, isThumbnail,created_at,updated_at)
Orders(id, sub_total, shipping_fee, total, status, userId, address, phone, fullname, created_at)
OrderDetails(id, order_id, product_id, quantity, price,created_at)
Brands(id, name, description,created_at) 
Comments(id, product_id, user_id, content, created_at)
ratings (id, product_id, user_id, point, created_at, update_at, deleted_at)
```
