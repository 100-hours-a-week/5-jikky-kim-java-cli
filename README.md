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
![클래스 다이어그램](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/b96540d2-673d-4e58-9da9-b51400f7ccde)

---

### Main & Pos

- Main 클래스는 Pos 객체를 생성하고 프로그램을 실행
- Main 클래스는 프로그램 시작점으로, 다른 클래스 및 서비스의 설정과 초기화를 담당하게 했습니다.

- Pos 클래스는  **`InventoryService`**, **`CartService`**, **`UserManager`**, **`InputService`** 사용
- 프로그램의 주요 기능을 한 곳에서 관리할 수 있게 했습니다.

![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/cee289fa-7ffc-4b35-a3fd-75ab21c55693)

---

### 인터페이스와 구현 클래스 

<aside>
💡 클래스가 복잡하지않은데, 인터페이스와 구현클래스를 구분한 이유

</aside>

원래는 인터페이스와 구현클래스를 구분하지 않았습니다.

SOLID를 알게되고, 기존 코드의 Pos클래스가 InventoryService, CartService,UserManager 클래스의 구체적인 구현에 의존하고 있어서 DIP를 준수하지 않고 있다고 생각했습니다.

따라서, DIP를 준수하기 위해 Pos클래스에서 사용하는 서비스들을 인터페이스로 추상화하고 구체적인 구현은 생성자 주입을 통해 주입받도록 했습니다.

|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/2ee12213-455e-4d42-8482-cc6b15a69417)|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/ba71db32-27e0-4955-aaf5-8d3f317287cb)|
|:---|:---|
|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/4cd37d75-3e10-407b-bd27-3ca485f3c3e5)|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/1a2cf873-be5c-48b6-b418-1cef6a0c0dd6)|


### Clothes

![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/183438e3-1a70-491a-82ec-2de1e25df2b3)

의류 항목을 공통 기능과 속성을 가진 상위 클래스와, 구체적인 특성을 가진 하위 클래스로 분리해서 유연성과 재사용성을 높입니다. 이를 통해 LSP와 OCP를 준수합니다.

- 슈퍼 클래스 : Clothes , 모든 의류 항목의 공통 속성과 메서드를 정의
    - 서브 클래스
        - ChildrenClothes  : 어린이용 의류, **`Clothes`** 클래스를 상속받아 할인율 속성을 추가
        - AdultClothes  : 성인용 의류
- 슈퍼 클래스 : AdultClothes
    - 서브 클래스
        - ManClothes  : 남성용 의류
        - WomanClothes  : 여성용 의류

---

### User

![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/0e743ec7-9eee-4a64-9c1a-ea4cb07f22a5)


- 슈퍼 클래스 : User
    - 서브 클래스
        - Customer : 일반 고객
        - Admin : 관리자

---


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

---

## 스레드 추가

## 스레드를 이용한 유저 로그 구현

스레드를 이용해서 프로그램의 메인 흐름과 관계없이 비동기적으로 로그 생성

**Pos class**

```java
// Pos class의 showMenu() 중 메뉴 선택 부분
switch (choice) {
                case Constants.DISPLAY_INVENTORY:
                    inventoryService.displayInventory();
                    logService.log(String.format(Constants.LOG_USER_VIEWED_INVENTORY, username));
                    break;
                case Constants.ADD_ITEM_TO_CART:
                    cartService.addItemToCart(inputService);
                    logService.log(String.format(Constants.LOG_USER_ADDED_ITEM_TO_CART, username));
                    break;
                case Constants.VIEW_CART:
                    cartService.viewCart();
                    logService.log(String.format(Constants.LOG_USER_VIEWED_CART, username));
                    break;
                case Constants.CHECKOUT:
                    cartService.checkout();
                    logService.log(String.format(Constants.LOG_USER_CHECKED_OUT, username));
                    break;
                case Constants.MANAGE_INVENTORY:
                    if (user instanceof Admin) {
                        ((Admin) user).manageInventory(inputService, inventoryService);
                        logService.log(Constants.LOG_ADMIN_MANAGED_INVENTORY);
                    } else {
                        System.out.println(Constants.EXIT_MESSAGE);
                        logService.log(String.format(Constants.LOG_USER_EXITED, username));
                        return;
                    }
                    break;
                case Constants.EXIT:
                    System.out.println(Constants.EXIT_MESSAGE);
                    logService.log(String.format(Constants.LOG_USER_EXITED, username));
                    return;
                default:
                    System.out.println(Constants.INVALID_CHOICE);
            }
```

### 2. 로그 작업 처리

**`ExecutorService`**

- 로그 작업을 관리하고, 프로그램 종료 시 모든 로그 작업이 완료된 후 스트림닫음
- 스레드를 생성해서 작업을 처리하고, 처리가 완료되면 해당 스레드를 제거하는 작업에 이용
- `log(String message)`
    - 로그 메세지 기록
    
- `close()`
    - ExecutorService 종료 후 BufferedWriter를 닫음
    - ExecutorService 작업이 5초가 지나도 안끝나면 강제 종료

**LogService class**

```java
package com.shop.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LogService {
    private final BufferedWriter writer;
    private final ExecutorService executor;

    public LogService(String logFileName) throws IOException {
        writer = new BufferedWriter(new FileWriter(logFileName, true));
        executor = Executors.newSingleThreadExecutor();
    }

    public void log(String message) {
        executor.submit(() -> {
            try {
                String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                writer.write(timeStamp + " - " + message);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                e.getStackTrace();
            }
        });
    }

    public void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
            writer.close();
        } catch (IOException | InterruptedException e) {
            e.getStackTrace();
        }
    }
}
```

### 실행 결과 생성되는 로그

**user_activity.log**

```java
2024-05-24 11:58:39 - User [admin] logged in.
2024-05-24 11:58:40 - User  [admin]  viewed inventory
2024-05-24 11:58:46 - User  [admin]  added item to cart
2024-05-24 11:58:48 - User  [admin]  viewed cart
2024-05-24 11:58:49 - User  [admin]  checked out
2024-05-24 11:58:51 - User  [admin]  exited.
2024-05-24 13:36:19 - User [customer] logged in.
2024-05-24 13:36:22 - User  [customer]  viewed inventory
2024-05-24 13:36:26 - User  [customer]  added item to cart
2024-05-24 13:36:28 - User  [customer]  added item to cart
2024-05-24 13:36:29 - User  [customer]  added item to cart
2024-05-24 13:36:31 - User  [customer]  viewed inventory
2024-05-24 13:36:31 - User  [customer]  exited.
```

---

## 스레드간 상호작용할 수 있는 기능 구현 

<aside>
💡 **LogService**가 로그를 기록하면 **SharedResource**를 통해 **LogMonitorThread**에게 알리고 사용자에게 실시간 알

</aside>

### LogService

- **`log`** 메서드가 호출될 때마다 로그 메시지를 파일에 기록
- 로그가 업데이트되면 `SharedResource`의 `updateLog` 메서드를 호출

```java
 public void log(String message) {
        try {
            executor.submit(() -> {
                try {
                    String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    writer.write(timeStamp + " - " + message);
                    writer.newLine();
                    writer.flush();
                    sharedResource.updateLog();
                } catch (IOException e) {
                    e.getStackTrace();
                }
            }).get();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
```

### SharedResource

- `updateLog` 메서드가 호출되면 **`logUpdated`** 플래그를 **true**로 설정하고 `notify`를 호출하여 대기 중인 스레드를 깨움
- `waitForLogUpdate` 메서드는 `logUpdated` 플래그가 `true`가 될 때까지 대기
    - 이 메서드는 `LogMonitorThread`에서 호출

```java
package com.shop.shared;

public class SharedResource {
    private boolean logUpdated = false;

    public synchronized void updateLog() {
        logUpdated = true;
        // wait() 상태에서 대기 중인 스레드 중 하나를 깨움
        notify();
    }

    public synchronized void waitForLogUpdate() throws InterruptedException {
        while (!logUpdated) {
            // logUpdated가 true가 될 때까지 대기
            wait();
        }
        // logUpdated 상태를 리셋
        logUpdated = false;
    }
}

```

### **LogMonitorThread**

- `run` 메서드에서 무한 루프로 `waitForLogUpdate`를 호출하여 로그 업데이트를 대기
- 로그가 업데이트되면 `SharedResource`의 **`waitForLogUpdate`** 메서드가 반환되고, 콘솔에 로그 업데이트 메시지를 출력

```java
package com.shop.monitor;

import com.shop.shared.SharedResource;
import com.shop.utils.Constants;

public class LogMonitorThread extends Thread {
    private final SharedResource sharedResource;

    public LogMonitorThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sharedResource.waitForLogUpdate();
                System.out.println(Constants.LOG_EMPTY);
                System.out.println(Constants.LOG_UPDATE_NOTIFY);
                System.out.println(Constants.LOG_EMPTY);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}

```

### Main

```java
package com.shop;

import com.shop.monitor.LogMonitorThread;
import com.shop.pos.Pos;
import com.shop.services.*;
import com.shop.shared.SharedResource;
import com.shop.user.User;
import com.shop.utils.Constants;
import com.shop.utils.InputServiceImpl;
import com.shop.managers.InventoryManager;
import com.shop.managers.CartManager;
import com.shop.managers.UserManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Constants.printKcsShopArt();

        InputServiceImpl inputService = new InputServiceImpl();
        InventoryManager inventoryManager = new InventoryManager();
        CartManager cartManager = new CartManager();
        UserManager userManager = new UserManager();

        InventoryService inventoryService = new InventoryServiceImpl(inventoryManager);
        CartService cartService = new CartServiceImpl(cartManager, inventoryManager);
        UserService userService = new UserServiceImpl(userManager);

        SharedResource sharedResource = new SharedResource();

        LogService logService;
        try {
            logService = new LogService(Constants.USER_LOG_FILE_NAME,sharedResource);
        } catch (IOException e) {
            e.getStackTrace();
            return;
        }

        LogMonitorThread logMonitorThread = new LogMonitorThread(sharedResource);
        logMonitorThread.start();

        Pos pos = new Pos(inputService, inventoryService, cartService, userService,logService);

        User user;
        do {
            user = pos.login();
        } while (user == null);
        pos.showMenu(user);

        inputService.close();
        logService.close();
    }
}

```

### 구현 결과



https://github.com/jjikky/5-jikky-kim-java-cli/assets/59151187/3a341c18-c2d7-4df3-9b04-e2f2aa8bef47



- 관리자 메뉴를 제외한 모든 메뉴를 선택시 `LogService`에서 스레드를 이용해 파일에 로그를 기록합니다.
- 로그가 업데이트되면 `SharedResource`의 `updateLog` 메서드를 호출해서 로그가 업데이트 되었음을 `LogMonitorThread`에 알립니다.
- 로그가 업데이트 되기를 기다리고 있다가 LogMonitorThread가 업데이트 됨을 감지하면, 콘솔에  📢`Log updated. Monitor thread notified.`📢 를 출력합니다.


시연 영상 결과 생성된 로그

```java
2024-05-24 23:11:24 - User [admin] logged in.
2024-05-24 23:11:26 - User [admin] viewed inventory.
2024-05-24 23:11:33 - User [admin] added item to cart.
2024-05-24 23:11:37 - User [admin] added item to cart.
2024-05-24 23:11:43 - User [admin] viewed cart.
2024-05-24 23:11:48 - User [admin] checked out.
2024-05-24 23:12:09 - Admin managed inventory.
2024-05-24 23:12:11 - User [admin] viewed inventory.
2024-05-24 23:12:24 - Admin managed inventory.
2024-05-24 23:12:29 - User [admin] viewed inventory.
2024-05-24 23:12:33 - User [admin] exited.
```
