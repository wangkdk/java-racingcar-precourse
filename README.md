# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현할 기능 목록

### Domain 로직

* [x] 자동차 기능
    * [x] 이름 부여
        * [x] 이름은 1글자 이상 5글자 이하
        * [x] 중복된 이름 검사
    * [x] 자동차 결과
        * [x] 차이름, 위치
* [ ] 경주 기능
    * [x] 경주용 자동차들 생성
        * [x] 최소 1대 이상 참여
    * [x] 경기 진행
        * [x] 자동차 별로 랜덤한 숫자를 부여해서 전진할지 멈출지 판단
* [x] 경기 규칙
    * [x] 경주 숫자
        * [x] 0 ~ 9 사이의 숫자
    * [x] 경주 결과 판단
        * [x] 4 이상일 경우 전진
        * [x] 3 이하의 경우 멈춤
* [x] 경기 결과
    * [x] 라운드별 경기 결과
    * [x] 최종 우승자

### Controller 로직

* [x] 자동차 생성기능
    * [x] 입력받은 이름을 쉼표를 기준으로 구분하여 생성
* [x] 시도 횟수
* [x] 경기 진행
* [ ] 결과 발표

### UI 로직

* [x] 경주할 자동차 이름 입력 기능
* [x] 경주 횟수 입력 기능
    * [x] 숫자로만 입력 가능
* [x] 실행 결과
* [ ] 최종 우승자 발표 기능
