# java-chicken-2019
## 치킨집 포스기를 구현한다.  
1. 주문등록, 결제, 종료 기능이 있다.  
1. 메뉴기본정보가 주어지며 메뉴번호, 종류, 이름, 가격을 가진다.   
1. 테이블기본정보가 주어지며 테이블번호를 가진다.  
1. 한 테이블에서 주문할 수 있는 한 메뉴의 최대수량은 **99**개이다.  
1. 주문이 등록된 테이블은 결제가 이루어지기 전까지 테이블목록에 별도로 표시한다.  

## 요구사항   
1. 결제는 현금, 신용카드로 할수 있다.  
    - 현금 결제시 5% 추가 할인 된다.  
1. **치킨종류의 메뉴 수량합이 10개**가넘는경우 **10,000원씩할인**된다.    
    - 치킨 종류 11개 : 10,000원 할인  
    - 치킨 종류 26개 : 20,000원 할인  
1. 주문, 결제가 불가능한 경우 이유(예외 메세지)를 출력한다.
    - 다시 주문, 결제가 가능하도록 해야 한다.

### 흐름
프로그램 on  
포스기 기능을 선택한다.  (1.주문, 2.결제, 3.종료)
1. 주문을 하는 경우  
    - 현재 테이블 목록을 출력한다. 
    - 테이블 목록중, 주문을 받을 테이블을 입력받는다. (출력된 테이블 번호중 하나)
        - 올바르지 않는 테이블 번호 입력시, 예외 발생 및 초기 화면으로 돌아간다. 
    - 전체 메뉴 목록을 출력한다. 
    - 등록할 메뉴를 입력 받는다. (메뉴판 번호)
        - 올바르지 않는 메뉴 번호 입력시, 예외 발생 및 초기 화면으로 돌아간다.  
    - 해당 메뉴의 수량을 입력 받는다. (1-99)
        - 범위 밖의 숫자, 값 입력시 예외 발생 및 초기 화면으로 돌아간다. 
        - 해당 테이블에서 최대치 이상 주문 받는 경우 예외 발생 및 초기 화면으로 돌아간다.
    - 여기까지 이뤄졌으면 초기 화면으로 돌아간다. 
    
2. 결제를 하는 경우  
    - 현재 테이블 목록을 출력한다. 
    - 테이블 목록중, 결제할 테이블을 입력받는다. (출력된 테이블 번호중 하나)
        - 올바르지 않는 테이블 번호 입력시, 예외 발생 및 초기 화면으로 돌아간다.
        - 주문이 이뤄진 테이블이 아닌 경우, 예외 발생 및 초기 화면으로 돌아간다.  
    - 해당 테이블의 주문 내역, (메뉴이름, 수량, 가격)을 출력한다. 
    - 결제 수단을 입력 받는다. (1: 신용카드, 2: 현금)
        - 1,2 외의 값을 입력 받는 경우, 예외 발생 및 초기 화면으로 돌아간다.  
    - 결제 수단 및 주문 수량에 따른 할인 적용후, 최종 결제 금액을 계산한다.
        - 치킨 메뉴 총 수량 10개 단위 별 10,000원 할인  
        - 현금 결제시 추가 5% 할인  
    - 계산된 최종 결제 금액 출력한다.   
    - 여기까지 이뤄졌으면 초기 화면으로 돌아간다.
    
3. 종료를 하는 경우
    - 종료 안내문 출력한다. 
    - 종료.  
    
### 도메인 구조 
테이블 - 1 번호, 1 주문 
    - [o] 주문 내역이 있는가? 
    - [o] 이 메뉴를 추가하자.
    - [o] 이 테이블에서는 치킨이 몇개 있는가?  
    - [o] 총 주문 금액은 얼마인가? 

주문 - 1 (메뉴/갯수) 
    - [o] 이 메뉴의 갯수가 99개 이하인가?  
    - [o] 총 주문 금액을 가져오자,
    - [o] 이 주문은 치킨이 몇개 있는가?
    - [o] 주문 내역이 비어있는가? 

메뉴 - 1 번호, 1 이름, 1 카테고리, 1 가격

결제수단 - 
    - [o] 입력 값에 따라서 가격을 가져온다. 

결제 가격 계산기   - 1 할인 전략
    - input table (입력 받아서 계산한다.)

할인 전략  
    - 추가 할인 전략 . input 총 계산 금액 => 할인된 금액 반환.  
    - 할인 금액 계산 전략 (input 주문) (output 할인 금액)
        - [o] 치킨 갯수 할인 전략  
        - [o] 현금 할인 전략 : 현금 결제하는 경우, 5% 추가 할인 된다. 
        - 종합 전략 (치킨 갯수 할인 + 현금 할인)