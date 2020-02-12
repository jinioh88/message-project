"# message-project" 

- Config 파일에서 메서드에 @Bean을 사용하는 방법은 적은 수의 빈을 초기화 할 때만 적합하다.
- 스프링은 어노테이션 기반 설정을 제공한다. 
  - 첫번째는 빈을 선언하는 어노테이션.
  - 두번째는 의존성을 연결하는 어노테이션.
  
- 의존성 주입 모범 사례
  - 반드시 필요한 의존성은 항상 생성자를 통해 주입하자.
  - 선택적인 의존성은 세터/메서드를 통해 주입할 수 있다. 
  - 필드 기반 주입은 사용하지말자.(Test 코드에선 사용하던데...)
    - 단일 책임 원칙을 위반할 수 있다.
    
---
- 자바 EE에서 모든 요청에 대해 HttpServletRequest 인스턴스가 생성된다.
- 모든 Http 응답에 HttpServletResponse 인스턴스가 생성된다.
- 여러 요청에서 사용자를 식별하기 위해 애플리케이션 서버는 첫 번째 요청을 받을 때 HttpSession인스턴스를 생성한다.
- 스프링 MVC를 활용하면 서블릿을 생성할 필요가 없다.
- 스프링은 요청을 받기 위해 핵심 서블릿인 DispatcherServlet을 활용한다.
---
핕터
- 필터는 디자인 패턴인 책임 연쇄 패턴을 구현한 것이다.
- 서블릿에 도달하기 전 HTTP 요청에 대한 필터링 작업을 수행할 때 유용하다.
- 스프링 부트에서 필터를 등록 하는 방법은 두 가지가 있다.
  - web.xml 파일에서 <filter>와 <filter-mapping>을 추가.
  - FilterRegistrationBean을 만들어 설정 클래스에 등록.   
---
JDBC
- JDBC API는 데이터베이스와의 상호작용을 해결한다.
- JPA는 객체지향 방식으로 데이터베이스에 객체를 저장하고 가져오는 방법을 담당한다.
- JPA 구현체는 데이터베이스에 접근하기 위해 JDBC 드라이버에 의존한다.
- JDBC API는 매우 하위 수준이고 이것을 사용하려면 불필요하게 중복되는 코드가 많이 필요하다.
---
스프링 JDBC
- JdbcTemplate 클래스가 핵심이다. 연결을 관리하고 JDBC API와 상호작용하는 워크플로를 제공하는데 도움을 준다. 
- 직접 JDBC API를 사용한 것 보다구현이 단순해진다. 
---
하이버네이트

