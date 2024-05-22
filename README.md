## 주제

간단한 POS 시스템을 구현했습니다.

- 사용자는 관리자와 고객으로 나뉘어져 있으며, 각 역할에 맞는 아이디와 비밀번호를 입력하면, 역할에 맞는 메뉴가 표시됩니다.
- 사용자의 경우 재고를 보고 장바구니에 담아 구매 할 수 있으며, 관리자의 경우에는 재고를 추가 혹은 삭제 할 수 있는 기능이 메뉴에 추가 됩니다.

- 테스트 계정
     - ADMIN ID & PASSWORD : admin
     - CUSTOMER ID & PASSWORD : CUSTOMER

## 기능

### 사용자 기능

- **로그인**: 사용자 이름과 비밀번호를 입력하여 시스템에 로그인할 수 있습니다.
- **메뉴 보기**: 로그인 후 사용자는 메뉴에서 다양한 옵션을 선택할 수 있습니다.
    - **메뉴**
        - View Inventory
        - Add item to Cart
        - View Cart
        - Checkout
        - ManageInventory ( 관리자 )
        - Exit

### 고객 기능

- **재고 보기**: 현재 재고 목록을 확인할 수 있습니다.
- **장바구니에 항목 추가**: 재고에서 항목을 선택해 장바구니에 추가할 수 있습니다.
- **장바구니 보기**: 현재 장바구니에 담긴 품목을 확인할 수 있습니다.
- **결제**: 장바구니의 항목을 결제하고 장바구니를 비웁니다.

### 관리자 기능

- **재고 추가**: 새로운 항목을 재고에 추가합니다.
- **재고 제거**: 기존 항목을 재고에서 제거합니다.

## 클래스 설계도

### 전체
![클래스 다이어그램](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/31dbd137-cd76-4133-a589-410cf72dafc0)

### Clothes

![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/8fcd8c45-ca82-4858-bf30-7df32996a3ad)


- 슈퍼 클래스 : Clothes , 모든 의류 항목의 공통 속성과 메서드를 정의
    - 서브 클래스
        - Children : 어린이용 의류, **`Clothes`** 클래스를 상속받아 할인율 속성을 추가
        - Adult : 성인용 의류
- 슈퍼 클래스 : Adult
    - 서브 클래스
        - Man : 남성용 의류
        - Woman : 여성용 의류

---

### User

![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/0e743ec7-9eee-4a64-9c1a-ea4cb07f22a5)


- 슈퍼 클래스 : User
    - 서브 클래스
        - Customer : 일반 고객
        - Admin : 관리자

---

### Pos

- Main 클래스는 Pos 객체를 생성하고 프로그램을 실행
- Pos 클래스는  **`InventoryService`**, **`CartService`**, **`UserManager`**, **`InputService`** 사용

![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/cee289fa-7ffc-4b35-a3fd-75ab21c55693)


|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/2ee12213-455e-4d42-8482-cc6b15a69417)|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/ba71db32-27e0-4955-aaf5-8d3f317287cb)|
|:---|:---|
|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/4cd37d75-3e10-407b-bd27-3ca485f3c3e5)|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/1a2cf873-be5c-48b6-b418-1cef6a0c0dd6)|



## 폴더 구조

```java
└── src.main.java.com.clothes
     ├── Main.java
     ├── pos
     │     └── Pos.java
     ├── services
     │     ├── CartService.java
     │     ├── CartServiceImpl.java
     │     ├── InputService.java
     │     ├── InputServiceImpl.java
     │     ├── UserService.java
     │     └── UserServiceImpl.java
     ├── managers
     │     ├── CartManager.java
     │     ├── InventoryManger.java
     │     └── UserManager.java
     ├── utils
     │     ├── InputService.java
     │     ├── InputServiceImpl.java
     │     └── Constants.java
     ├── user
     │     ├── User.java
     │     ├── Customer.java
     │     └── Admin.java
     └── clothes
           ├── Clothes.java
           ├── Children.java
           ├── Adult.java
           ├── Man.java
           └── Woman.java
```

## 폴더 및 파일 설명
**com/shop/**

- **Main.java**: 프로그램 진입점

**com/shop/pos/**

- **Pos.java**: 주요 애플리케이션 로직을 담당하는 클래스. 여러 서비스 클래스와 상호작용

**com/shop/services/**

- **CartService.java**: 장바구니 서비스 인터페이스
- **CartServiceImpl.java**: 장바구니 서비스 구현 클래스
- **InventoryService.java**: 재고 관리 서비스 인터페이
- **InventoryServiceImpl.java**: 재고 관리 서비스 구현 클래스
- **UserService.java**: 사용자 서비스 인터페이스
- **UserServiceImpl.java**: 사용자 서비스 구현 클래스

**com/shop/managers/**

- **CartManager.java**: 장바구니 데이터 관리를 담당하는 클래스
- **InventoryManager.java**: 재고 데이터 관리를 담당하는 클래스
- **UserManager.java**: 사용자 데이터 관리를 담당하는 클래스

**com/shop/user/**

- **Admin.java**: 관리자 사용자 클래스, **`User`**를 상속
- **Customer.java**: 고객 사용자 클래스, **`User`**를 상속
- **User.java**: 기본 사용자 클래스

**com/shop/clothes/**

- **Children.java**: 어린이용 의류 클래스, **`Clothes`**를 상속
- **Clothes.java**: 의류의 기본 클래스
- **Man.java**: 남성용 의류 클래스, **`Clothes`**를 상속
- **Woman.java**: 여성용 의류 클래스, **`Clothes`**를 상속

**com/shop/utils/**

- **Constants.java**: 상수 값을 정의하는 클래스
- **InputService.java**: 입력 서비스 인터페이스
- **ScannerInputService.java**: **`InputService`**를 구현한 클래스, **`Scanner`**를 사용하여 입력을 처리

---

## **프로그램 실행 흐름**

### **1. 프로그램 시작 (Main 클래스)**

- **`Main`** 클래스의 **`main`** 메서드가 실행
- **`Constants.printKcsShopArt()`**를 호출하여 아스키아트를 출력
- **`InputService`** 인터페이스를 구현한 **`InputServiceImpl`** 객체를 생성합니다.
- **`InventoryManager`**, **`CartManager`**, **`UserManager`** 객체를 생성합니다.
- **`InventoryService`**, **`CartService`**, **`UserService`** 인터페이스의 구현체(**`InventoryServiceImpl`**, **`CartServiceImpl`**, **`UserServiceImpl`**)를 생성하고 각 매니저 객체를 주입
- **`Pos`** 객체를 생성하고 필요한 서비스 객체들을 주입

```java
public class Main {
    public static void main(String[] args) {
        Constants.printKcsShopArt();
        
        InputService inputService = new InputServiceImpl();
        InventoryManager inventoryManager = new InventoryManager();
        CartManager cartManager = new CartManager();
        UserManager userManager = new UserManager();

        InventoryService inventoryService = new InventoryServiceImpl(inventoryManager);
        CartService cartService = new CartServiceImpl(cartManager, inventoryManager);
        UserService userService = new UserServiceImpl(userManager);
        
        Pos pos = new Pos(inputService, inventoryService, cartService, userService);

        User user;
        do {
            user = pos.login();
        } while (user == null);
        pos.showMenu(user);

        ((InputServiceImpl) inputService).close();
    }
}
```

### **2. 로그인 절차 (Pos 클래스)**

- **`Pos`** 클래스의 `**login**` 메서드가 호출
- 사용자 이름과 비밀번호를 입력받기 위해 **`inputService.getInput()`**을 호출
- **`userService.login`** 메서드를 호출하여 입력받은 사용자 이름과 비밀번호를 검증
- 검증에 성공하면 **`User`** 객체를 반환하고, 실패하면 로그인 실패 메시지를 출력하고 다시 로그인 시도

```java
public class Pos {
    private final InventoryService inventoryService;
    private final CartService cartService;
    private final UserService userService;
    private final InputService inputService;

    public Pos(InputService inputService, InventoryService inventoryService, CartService cartService, UserService userService) {
        this.inventoryService = inventoryService;
        this.cartService = cartService;
        this.userService = userService;
        this.inputService = inputService;
    }

    public User login() {
        System.out.print(Constants.ENTER_USERNAME);
        String username = inputService.getInput();
        System.out.print(Constants.ENTER_PASSWORD);
        String password = inputService.getInput();
        return userService.login(username, password);
    }

    public void showMenu(User user) {
        while (true) {
            System.out.println(Constants.WELCOME_MESSAGE);
            System.out.println(Constants.DEVIDE_LINE);
            System.out.println(Constants.MAIN_MENU_OPTIONS);
            if (user instanceof Admin) {
                System.out.println(Constants.ADMIN_MENU_OPTIONS);
            } else {
                System.out.println(Constants.CUSTOMER_MENU_OPTIONS);
            }
            System.out.println(Constants.DEVIDE_LINE);
            System.out.print(Constants.SELECT_OPTION);
            int choice = inputService.getIntInput();

            switch (choice) {
                case 1:
                    inventoryService.displayInventory();
                    break;
                case 2:
                    cartService.addItemToCart(inputService);
                    break;
                case 3:
                    cartService.viewCart();
                    break;
                case 4:
                    cartService.checkout();
                    break;
                case 5:
                    if (user instanceof Admin) {
                        ((Admin) user).manageInventory(inputService, inventoryService);
                    } else {
                        System.out.println(Constants.EXIT_MESSAGE);
                        return;
                    }
                    break;
                case 6:
                    System.out.println(Constants.EXIT_MESSAGE);
                    return;
                default:
                    System.out.println(Constants.INVALID_CHOICE);
            }
        }
    }
}

```

### **3. 메뉴 표시 및 선택 (Pos 클래스)**

- 로그인 성공 후, **`showMenu`** 메서드가 호출되어 사용자에게 메뉴를 표시
- 사용자는 메뉴에서 원하는 옵션을 선택
- 선택된 옵션에 따라 적절한 메서드가 호출
    - **1: 재고 보기** (**`InventoryService.displayInventory`**)
        - 현재 재고 목록을 출력
    - **2: 장바구니에 항목 추가** (**`CartService.addItemToCart`**)
        - 사용자로부터 추가할 항목 번호를 입력받아 장바구니에 추가
    - **3: 장바구니 보기** (**`CartService.viewCart`**)
        - 현재 장바구니에 있는 항목들을 출력
    - **4: 결제** (**`CartService.checkout`**)
        - 장바구니의 항목들을 출력하고 총 금액을 계산하여 출력 후, 결제가 완료되면 장바구니를 비움
    - **5: 재고 관리** (**`Admin.manageInventory`** - 관리자 전용)
        - 관리자 전용 옵션으로, 재고 관리 메뉴를 표시
        - 재고 추가, 재고 제거, 메뉴로 돌아가기 등의 기능을 제공
    - **6: 종료**
        - 프로그램을 종료
    - **기타**: 유효하지 않은 선택에 대해 오류 메시지를 출력

### **4. 재고 관리 (Admin 클래스)**

- **재고 관리 메뉴**:
    - **1: 재고 추가** (**`InventoryService.addItemToInventory`**)
        - 새로운 항목의 유형, 이름, 가격, 할인율(해당되는 경우)을 입력받아 재고에 추가
    - **2: 재고 제거** (**`InventoryService.removeItemFromInventory`**)
        - 제거할 항목 번호를 입력받아 재고에서 제거
    - **3: 메뉴로 돌아가기**
        - 재고 관리 메뉴를 종료하고 메인 메뉴로 돌아가기

```java
public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void loginSuccess() {
        System.out.println(Constants.LOGIN_SUCCESS_ADMIN);
    }

    public void manageInventory(InputService inputService, InventoryService inventoryService) {
        while (true) {
            System.out.println(Constants.INVENTORY_MANAGEMENT_OPTIONS);
            System.out.print(Constants.SELECT_OPTION);
            int choice = inputService.getIntInput();

            switch (choice) {
                case 1:
                    inventoryService.addNewItemToInventory(inputService);
                    break;
                case 2:
                    inventoryService.removeItemFromInventory(inputService);
                    break;
                case 3:
                    return;
                default:
                    System.out.println(Constants.INVALID_CHOICE);
            }
        }
    }
}
```

### **5. 입력 서비스 (InputService 인터페이스 및 구현)**

- **`InputService`** 인터페이스를 통해 입력을 추상화
- `**InputServiceImpl**`클래스는 **`Scanner`**를 사용 입력을 처리
- 프로그램 종료 시 **`InputServiceImpl.close()`** 메서드를 호출하여 **`Scanner`** 객체를 닫아 리소스를 해제

---

## 구현 결과

### Customer

https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/3b78864d-7045-4f19-a309-73d431004bde

### Admin

https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/80c251ef-fc2c-412d-a878-dce0e3c6ef2e

