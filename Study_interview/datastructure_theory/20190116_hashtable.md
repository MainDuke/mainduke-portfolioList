* 해시 함수란?

해시함수(hash function)란 데이터의 효율적 관리를 목적으로 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수입니다.

~~~
이 때 매핑 전 원래 데이터의 값을 키(key), 매핑 후 데이터의 값을 해시값(hash value),
매핑하는 과정 자체를 해싱(hashing)라고 합니다.
~~~

Exemple
키 - > 해시 값 ( 이과정을 해싱)

~~~
 * 해시충돌(collision) 이란?
 많은 키값을 해싱하다보면 해쉬값이 충돌이 일어남.
~~~

 해시충돌이 발생할 가능성이 있음에도 해시테이블을 쓰는 이유는 적은 리소스로 많은 데이터를 효율적으로 관리하기 위해서입니다.

~~~
무한한 데이터(키)  => 유한한 해쉬값으로 매핑
 작은 크기의 캐쉬 메모리로도 프로세스를 관리할 수 있게 됨!
 ~~~


 인덱스(색인)에 해시값을 사용함으로서 올 스캔 없이 검색 삽입을 할 수 있다.


해시함수는 언제나 동일한 해시값을 리턴하고, 해당 색인만 알면 해시테이블의 크기에 상관없이 데이터에 대단히 빠르게 접근할 수 있으며, 색인은 계산이 간단한 함수(상수시간)로 작동하기 때문에 매우 효율적입니다.

~~~
* 다시 말해 해시는 데이터 액세스(삽입, 삭제, 탐색)시 계산복잡성을 O(1)을 지향합니다.
~~~

이진트리
변형 : 메모리 효율적
탐색 : 계산 복잡성 O( nLogn)

배열
탐색 : O(1)
메모리 : 공간 효율성 떨어짐

해시는 보안에서 많이 쓰인다. 단방향으로 변환이 되며, 키와 해시값 연관성이 없다.
복원이 힘들다는점.

<h1>Hash Table</h1>
드디어 나왔다.
해시 함수를 사용해서 키를 해시값으로 매핑하고,
이 해시값을 인덱스 혹은 주소 삼아 데이터값을 키와 함께 저장하는 구조를 해시 테이블 이라고 합니다.

이때 데이터가 저장되는 곳을 버킷 또는 슬롯이라고 한다. bucket, slot
* 해시 테이블의 기본 연산은 = 삽입 삭제 탐색 이다.

![HashTable](../Src/20190116_hashtable-000.png)
출처 : https://ratsgo.github.io/ata%20structure&algorithm/2017/10/25/hash/


*  키의 전체 개수와 동일한 크기의 버킷을 가진 해시테이블을 Direct-address table
해시 충돌이 일어나지 않는다.
그러나, 불필요한 키 값을 위한 인덱스를 만들어야하므로, 메모리 효율은 떨어진다.

실제로는 해시테이블의 크기를 조절함.
~~~
해시테이블 크기(m)가 실제 사용하는 키 개수(n)
n/m을 load factor(α)
해시테이블의 한 버킷에 평균 몇 개의 키가 매핑되는가를 나타내는 지표입니다. Direct-address table의 load factor는 1 이하이며, 1보다 큰 경우 해시충돌 문제가 발생합니다.
~~~

콜루젼 (해시충돌) 막기 위한 방법
1. Chaining 사슬화
   chaining은 해시테이블의 크기를 유연하게 만들고, open addressing은 해시테이블 크기는 고정시키되 저장해 둘 위치를 잘 찾는 데 관심을 둔 구조

해시 충돌이 일어날 때, 각 버킷에 들어가는 엔트리의 숫자를 1:1 이 아닌 다수가 가능하게 만들었다. 그리고 연결 리스트로 각 엔트리를 연결한다.
메모리 적인 문제가 생길 수 있다.

<체인 계산복잡성 계산>
삽입: 매핑 O(1) , 연결리스트 추가 O(1)
탐색: 1. 실패탐색 = O(1+a) 2. 성공탐색
삭제:

2. 오픈 어드레스
해시 충돌이 일어날 경우, 해당 버킷에서 다음 버킷으로 이동
선형 탐색(문제점 : 초반에 몰린경우 문제)
제곱 탐색(문제점 : 최초 해시가 같을 경우 문제)

이중해싱 : 해시값 반환 함수와 , 탐사 이동폭 함수를 2개를 써서 같은 인덱스여도 탐사폭이 다르다. 단, 서로소(공약수 1) 일때만 효과.

open addressing 탐색 연산의 계산복잡성은 α에 크게 영향을 받는 구조입니다. 따라서 해시테이블에 데이터가 어느 정도 차게 되면 해시테이블 크기 m을 적절하게 늘려주고 처음부터 다시 해싱을 하는 것이 좋다고 합니다. 삭제와 삽입 연산 역시 탐사 횟수가 중요하기 때문에 해시테이블 크기에 신경을 써주어야 합니다.

3. 해시함수를 건들여서 , 해시 충돌을 막는 방법들
division method 나눗셈법
multiplication method 제곱 방법
universal hasing  다수의 해시함수를 만들고, 이 해시함수의 집합 H에서 무작위로 해시함수를 선택해 해시값을 만드는 기법입니다. H에서 무작위로 뽑은 해시함수가 주어졌을 때 임의의 키값을 임의의 해시값에 매핑할 확률을 1/m로 만드려는 것이 목적입니다. 다음과 같은 특정 조건의 해시함수 집합 H는 1/m으로 만드는 게 가능하다고 수학적으로 증명됐습니다.