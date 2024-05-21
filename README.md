## 주제

옷가게 옷을 구매하고 재고를 추가/삭제 할 수 있는 프로그램

사용자는 관리자와 고객으로 나뉘어져 있으며,

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
|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/4e2057fa-09cf-48d7-b889-ad1f4052c9c2)|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/f574664a-7cab-4fa4-9f9a-a1d3e4b22d91)|
|슈퍼 클래스 : Clothes|슈퍼 클래스 : User|
|  서브 클래스 : Children, Adult|  서브 클래스 : Customer, Admin|
|슈퍼 클래스 : Adult||
|  서브 클래스 : Man, Woman||


| Pos | InputService | 
|:---|:---|
|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/7eede99f-af60-4ea6-9321-024d78f1defb)|![image](https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/49d33231-633c-4079-8f6b-cbf97a2dae0a)|
|Main 클래스는 Pos 객체를 생성하고 프로그램을 실행. Pos 객체와 연관 관계|ScannerInputService가 inputService인터페이스를 구현|
|Pos 클래스는  **`InventoryService`**, **`CartService`**, **`UserManager`**, **`InputService`** 객체에 의존|  |


## 폴더 구조

```java
└── src.main.java.com.clothes
     ├── Main.java
     ├── managers
     │     ├── CartManager.java
     │     ├── InventoryManger.java
     │     └── UserManager.java
     ├── services
     │     ├── CartService.java
     │     ├── InputService.java
     │     ├── InventoryService.java
     │     └── ScannerInputService.java
     ├── utils
     │     └── Constants.java
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

- Main : 애플리케이션 진입점
- Pos : 주요 로직을 담당, 주요 서비스 클래스(**`InventoryService`**, **`CartService`**, **`UserManager`**, **`InputService`**)와 상호작용
- Service  (**`InventoryService`**, **`CartService`**)  : 비즈니스 로직을 캡슐화
    - Manager 클래스를 사용하여 구체적인 작업을 수행
- Manager : 데이터 관리 및 CRUD 작업 처리
- User : 사용자 정보 관리
- InputService : 입력처리 인터페이스

## **프로그램 실행 흐름**

1. **프로그램 시작 (Main 클래스)**
    - **`Main`** 클래스의 **`main`** 메서드가 실행
    - **`Constants.printKcsShopArt()`**를 호출하여 아스키아트를 출력
    - **`ScannerInputService`** 객체를 생성하여 **`InputService`** 인터페이스로 사
    
2. **로그인 절차 (Pos 클래스)**
    - **`Pos`** 객체를 생성하면서 필요한 서비스 객체들(**`InventoryService`**, **`CartService`**, **`UserManager`**, **`InputService`**)을 주입
    - **`Pos`** 클래스의 `run` 메서드가 호출
    - **`Pos`** 클래스의 `login` 메서드가 호출
    - 사용자 이름과 비밀번호를 입력
    - `UserManager`를 통해 입력된 사용자 이름과 비밀번호를 검증
    - 검증에 성공하면 **`User`** 객체를 반환하고, 실패하면 로그인 실패 메시지를 출력하고 다시 로그인 시도
3. **메뉴 표시 및 선택 (Pos 클래스)**
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
4. **재고 관리 (Admin 클래스)**
    - **재고 관리 메뉴**:
        - **1: 재고 추가** (**`InventoryService.addItemToInventory`**)
            - 새로운 항목의 유형, 이름, 가격, 할인율(해당되는 경우)을 입력받아 재고에 추가
        - **2: 재고 제거** (**`InventoryService.removeItemFromInventory`**)
            - 제거할 항목 번호를 입력받아 재고에서 제거
        - **3: 메뉴로 돌아가기**
            - 재고 관리 메뉴를 종료하고 메인 메뉴로 돌아가기
5. **입력 서비스 (InputService 인터페이스 및 구현)**
    - **`InputService`** 인터페이스를 통해 입력을 추상화
    - **`ScannerInputService`** 클래스는 `Scanner`를 사용하여 실제 입력을 처리
    - **`close`** 메서드를 통해 **`Scanner`** 객체를 닫아 리소스를 정리
## 구현 결과

### Customer

https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/3b78864d-7045-4f19-a309-73d431004bde

### Admin

https://github.com/jjikky/clothing-shop-java-cli/assets/59151187/80c251ef-fc2c-412d-a878-dce0e3c6ef2e

