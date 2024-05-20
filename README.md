## 주제

옷가게 포스

관리자와 고객으로 나뉘어져 있으며,

각 역할에 맞는 아이디와 비밀번호를 입력하면, 포스기 메뉴 표출

관리자의 경우에는 재고를 추가 혹은 삭제 할 수 있는 기능이 메뉴에 추가

메뉴

- View Inventory
- Add item to Cart
- View Cart
- Checkout
- ManageInventory ( 관리자 )
- Exit

## 클래스 설계도

| Clothes | User | 
|:---|:---|
|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/a4d40914-ccf5-4ae3-a804-10db4d2ff605)|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/e0669f6f-5784-44f8-ae75-6168a176a760)|
|슈퍼 클래스 : Clothes|슈퍼 클래스 : User|
|  서브 클래스 : Children, Adult|  서브 클래스 : Customer, Admin|
|슈퍼 클래스 : Adult||
|  서브 클래스 : Man, Woman||

- 로그아웃
- 프로그램 종료

### Pos

![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/cab19fd5-ddaf-4e30-99bc-ff9782bb3a35)

## 폴더 구조

```java
└── src.main.java.com.clothes
     ├── Main.java
     ├── user
     │     ├── User.java
     │     ├── Customer.java
     │     └── Admin.java
     ├── clothes
     │     ├── Clothes.java
     │     ├── Children.java
     │     ├── Adult.java
     │     ├── Man.java
     │     └── Woman.java
     └── pos
           └── Pos.java
```

## 구현 결과

### Customer

https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/3b78864d-7045-4f19-a309-73d431004bde

### Admin

https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/80c251ef-fc2c-412d-a878-dce0e3c6ef2e

