# java-racingcar-precourse
---

구현 기능 목록

InputView 
- [x] 자동차의 이름을 쉼표(,)를 기준으로 입력
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력
- [x] 이름은 5자 이하만 가능하다.
- [x] 사용자가 잘못된 값을 입력할 경우 IlleagalArgumentException을 발생 시킨 후 애플리케이션 종료
- [x] 사용자 입력 횟수에 대한 검증 필요 (공백이거나 숫자가 아닌 경우)
- [ ] 싱글톤 패턴 적용

OutputView
- [ ] 게임이 완료되면 누가 우승했는지를 출력 
- [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분
- [x] 싱글톤 패턴 적용
- [x] 자동차의 이름, 현재 위치 출력 기능

Game
- [ ] 자동차 관련 일급 컬렉션으로 변경
- [x] 주어진 횟수 동안 자동차들의 위치 이동
- [x] 이동마다 자동차의 위치를 출력 관련 View에 출력

Car
- [x] 자동차가 전진할 수 있는 지 검증 (0 ~ 9 사이의 무작위 값을 구한 후 무작위 값이 4 이상일 경우)
- [x] 전진할 수 있는 경우, 자동차 이동
- [ ] 이동 알고리즘 전략 패턴 적용



