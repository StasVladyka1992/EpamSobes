package Algorythm.greedy_algorythm;


import static Algorythm.greedy_algorythm.State.AZ;
import static Algorythm.greedy_algorythm.State.CA;
import static Algorythm.greedy_algorythm.State.ID;
import static Algorythm.greedy_algorythm.State.MT;
import static Algorythm.greedy_algorythm.State.NV;
import static Algorythm.greedy_algorythm.State.OR;
import static Algorythm.greedy_algorythm.State.UT;
import static Algorythm.greedy_algorythm.State.WA;
import static Algorythm.greedy_algorythm.Station.KFIVE;
import static Algorythm.greedy_algorythm.Station.KFOUR;
import static Algorythm.greedy_algorythm.Station.KONE;
import static Algorythm.greedy_algorythm.Station.KTHREE;
import static Algorythm.greedy_algorythm.Station.KTWO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
В алгоритме будут использоваться операции со множествами.
1) Создаем список из всех станций и список со штатами, которые требуется покрыть
2) Проходим по списку и ищем станцию, которая покрывает оптимальное количество штатов.
3) Добавляем такие станции до тех пор, пока количество покрытых штатов не станет требуемым.
Алгоритмическая сложность - O(n2)
 */
public class MultiplicityCovering {
	public static void main(String[] args) {
		MultiplicityCovering object = new MultiplicityCovering();
		Set<State> statesNeeded = new HashSet<>(Arrays.asList(State.values()));
		Map<Station, Set<State>> stations = object.createStations();

		Set<Station> result = object.findStationsList(statesNeeded, stations);
		result.forEach(System.out::println);
	}

	public Set<Station> findStationsList(Set<State> statesNeeded, Map<Station, Set<State>> stations) {
		Set<Station> finalStations = new HashSet<>();
		Set<State> coveredStates = new HashSet<>();

		while (coveredStates.size() < statesNeeded.size()) {
			Station bestStation = null;
			Set<State> bestStationStates = new HashSet<>();
			int bestStationStatesToAddNumber = 0;

			for (Map.Entry<Station, Set<State>> pair : stations.entrySet()) {
				int statesToAdd = multiplicityDifference(coveredStates, pair.getValue());

				if (bestStation == null || bestStationStatesToAddNumber < statesToAdd) {
					bestStation = pair.getKey();
					bestStationStatesToAddNumber = statesToAdd;
					bestStationStates = pair.getValue();
				}
			}

			coveredStates.addAll(bestStationStates);
			finalStations.add(bestStation);
			stations.remove(bestStation);
		}
		return finalStations;
	}

	private int multiplicityDifference(Set<State> coveredStates, Set<State> stationStates) {
		int initialCoveredNumber = coveredStates.size();
		Set<State> copyCoveredState = new HashSet<>(coveredStates);
		copyCoveredState.addAll(stationStates);
		return copyCoveredState.size() - initialCoveredNumber;
	}

	private Map<Station, Set<State>> createStations() {
		Map<Station, Set<State>> result = new HashMap<>();
		result.put(KONE, new HashSet<>(Arrays.asList(ID, NV, UT)));
		result.put(KTWO, new HashSet<>(Arrays.asList(WA, ID, MT)));
		result.put(KTHREE, new HashSet<>(Arrays.asList(OR, NV, CA)));
		result.put(KFOUR, new HashSet<>(Arrays.asList(NV, UT)));
		result.put(KFIVE, new HashSet<>(Arrays.asList(CA, AZ)));
		return result;
	}
}
